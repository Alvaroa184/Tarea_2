package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class ReunionTest {

    private Departamento ventas;
    private Empleado organizador;
    private Empleado invitado1;
    private ReunionVirtual reunionBase;

    @BeforeEach
    public void prepararEntorno() {
        ventas=new Departamento("Ventas", new ArrayList<>());
        organizador=new Empleado("001", "Carlos", "Perez", "carlos@udec.cl", ventas);
        invitado1=new Empleado("002", "Ana", "Gomez", "ana@udec.cl", ventas);

        reunionBase=new ReunionVirtual("meet.google", TipoReunion.TECNICA, organizador, LocalDate.now().plusDays(1), Duration.ofHours(2));
    }

    //Excepciones//

    @Test
    public void testAsistenciaDuplicadaExcepcion() {
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();
        reunionBase.registrarAsistencia(invitado1);

        assertThrows(AsistenciaDuplicadaException.class, () -> {
            reunionBase.registrarAsistencia(invitado1);
        });
    }

    @Test
    public void testDatoInvalidoExcepcion() {
        assertThrows(DatoInvalidoException.class, () -> {
            new ReunionPresencial("Sala A", TipoReunion.OTRO, organizador, LocalDate.now().minusDays(1), Duration.ofHours(1));
        });
    }

    @Test
    public void testDuracionInvalidaException() {
        assertThrows(DuracionInvalidaException.class, () -> {
            new ReunionVirtual("enlace.com", TipoReunion.TECNICA, organizador, LocalDate.now().plusDays(1), Duration.ZERO);
        });
    }

    @Test
    public void testInvitacionDuplicadaExcepcion() {
        reunionBase.registrarInvitacion(invitado1);

        assertThrows(InvitacionDuplicadaException.class, () -> {
            reunionBase.registrarInvitacion(invitado1);
        });
    }

    @Test
    public void testInvitadoNoinvitadoExcepcion() {
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();

        Empleado intruso = new Empleado("000", "Pedro", "Intruso", "pedro@udec.cl", ventas);

        assertThrows(InvitadoNoinvitadoException.class, () -> {
            reunionBase.registrarAsistencia(intruso);
        });
    }

    @Test
    public void testReunionNoFinalizadaExcepcion() {
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();

        assertThrows(ReunionNoFinalizadaException.class, () -> {
            reunionBase.calcularTiempoReal();
        });
    }

    @Test
    public void testReunionNoinicializadaExcepcion() {
        assertThrows(ReunionNoinicializadaException.class, () -> {
            reunionBase.finalizar();
        });
    }

    @Test
    public void testReunionYaFinalizadaExcepcion() {
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();
        reunionBase.finalizar();

        assertThrows(ReunionYaFinalizadaException.class, () -> {
            reunionBase.finalizar();
        });
    }

    @Test
    public void testReunionYainiciadaExcepcion() {
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();

        assertThrows(ReunionYainiciadaException.class, () -> {
            reunionBase.iniciar();
        });
    }

    @Test
    public void testSininvitadosException() {
        assertThrows(SininvitadosException.class, () -> {
            reunionBase.iniciar();
        });
    }

    //Caminos felices(Happy paths)//

    @Test
    public void testReunionCorrectaYCalculoDeTiempo() throws InterruptedException {
        reunionBase.registrarInvitacion(invitado1);

        assertDoesNotThrow(() -> {
            reunionBase.iniciar();
            Thread.sleep(5000);
            reunionBase.finalizar();
        });

        float tiempoEnMinutos = reunionBase.calcularTiempoReal();
        assertTrue(tiempoEnMinutos > 0.0f, "El tiempo real calculado no debe ser negativo y debe ser mayor a 0");
    }

    @Test
    public void testObtenerPorcentajeAsistenciaConAsistenciaPerfecta() {
        Empleado invitado2 = new Empleado("003", "Luis", "Soto", "luis@udec.cl", ventas);
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.registrarInvitacion(invitado2);
        reunionBase.iniciar();

        reunionBase.registrarAsistencia(invitado1);
        reunionBase.registrarAsistencia(invitado2);
        reunionBase.registrarAusencia();

        assertEquals(100.0f, reunionBase.obtenerPorcentajeAsistencia(), 0.01, "El porcentaje debe ser 100% si todos asisten");
        assertEquals(2, reunionBase.obtenerTotalAsistencia(), "El total de asistentes debe ser 2");
        assertEquals(0, reunionBase.obtenerAusencia().size(), "No debe haber ausencias");
    }

    @Test
    public void testObtenerPorcentajeAsistenciaConMitadAusentes() {
        Empleado invitado2 = new Empleado("003", "Luis", "Soto", "luis@udec.cl", ventas);
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.registrarInvitacion(invitado2);
        reunionBase.iniciar();

        reunionBase.registrarAsistencia(invitado1);
        reunionBase.registrarAusencia();

        assertEquals(50.0f, reunionBase.obtenerPorcentajeAsistencia(), 0.01, "El porcentaje debe ser 50% si falta la mitad");
        assertEquals(1, reunionBase.obtenerTotalAsistencia(), "El total de asistentes debe ser 1");
        assertEquals(1, reunionBase.obtenerAusencia().size(), "Debe haber 1 persona ausente");
    }

    @Test
    public void testRegistroDeNotasCorrectamente() {
        reunionBase.agregarNota("Tema 1: Presupuesto");
        reunionBase.agregarNota("Tema 2: Marketing");

        assertEquals(2, reunionBase.obtenerNotas().size(), "Deben haber 2 notas registradas");
        assertEquals("Tema 1: Presupuesto", reunionBase.obtenerNotas().get(0).getContenido(), "El contenido de la primera nota debe coincidir");
        assertEquals("Tema 2: Marketing", reunionBase.obtenerNotas().get(1).getContenido(), "El contenido de la segunda nota debe coincidir");
    }

    @Test
    public void testAsistenciaPerfectaConRetraso() throws InterruptedException {
        Empleado invitado2 = new Empleado("003", "Luis", "Soto", "luis@udec.cl", ventas);
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.registrarInvitacion(invitado2);
        reunionBase.iniciar();

        reunionBase.registrarAsistencia(invitado1);

        Thread.sleep(5000);
        reunionBase.registrarAsistencia(invitado2);

        reunionBase.registrarAusencia();

        assertEquals(100.0f, reunionBase.obtenerPorcentajeAsistencia(), 0.01, "El porcentaje debe ser 100% aunque haya retrasos");
        assertEquals(2, reunionBase.obtenerTotalAsistencia(), "Debe haber 2 asistencias registradas en total");
        assertEquals(1, reunionBase.obtenerRetraso().size(), "El sistema debe haber detectado 1 retraso");
        assertEquals(0, reunionBase.obtenerAusencia().size(), "No debe haber ausencias");
    }

    @Test
    public void testAsistenciaNoPerfectaConRetraso() throws InterruptedException {
        Empleado invitado2 = new Empleado("003", "Luis", "Soto", "luis@udec.cl", ventas);
        Empleado invitado3 = new Empleado("004", "Marta", "Rios", "marta@udec.cl", ventas);

        reunionBase.registrarInvitacion(invitado1);
        reunionBase.registrarInvitacion(invitado2);
        reunionBase.registrarInvitacion(invitado3);
        reunionBase.iniciar();

        reunionBase.registrarAsistencia(invitado1);
        Thread.sleep(5000);
        reunionBase.registrarAsistencia(invitado2);

        reunionBase.registrarAusencia();

        assertEquals(66.66f, reunionBase.obtenerPorcentajeAsistencia(), 0.1, "El porcentaje debe ser cercano a 66.66%");
        assertEquals(2, reunionBase.obtenerTotalAsistencia(), "Debe haber 2 personas que asistieron");
        assertEquals(1, reunionBase.obtenerRetraso().size(), "Debe haber 1 persona atrasada");
        assertEquals(1, reunionBase.obtenerAusencia().size(), "Debe haber 1 persona ausente");
    }

    @Test
    public void testgenerarInforme() throws IOException {
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();
        reunionBase.registrarAsistencia(invitado1);
        reunionBase.agregarNota("Tema 1: Presupuesto");
        reunionBase.agregarNota("Tema 2: Marketing");
        reunionBase.finalizar();

        File archivoGenerado = new File("informe.txt");

        reunionBase.generarInforme();

        assertTrue(archivoGenerado.exists(), "El archivo 'informe.txt' deberia haberse creado");
        assertTrue(archivoGenerado.length() > 0, "El archivo de informe no deberia estar vacio");

        assertTrue(archivoGenerado.delete(), "El archivo temporal de prueba deberia poder borrarse sin problemas");
    }

    @Test
    public void testAsistenciaDeInvitadoExternoExitosa() {
        Invitado_Externo externo1 = new Invitado_Externo("Juan", "Perez", "juan@uch.cl");
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.registrarInvitacion(externo1);
        reunionBase.iniciar();
        reunionBase.registrarAsistencia(externo1);
        reunionBase.registrarAsistencia(invitado1);
        reunionBase.registrarAusencia();

        assertEquals(2, reunionBase.obtenerTotalAsistencia(), "El invitado externo debe sumarse a la asistencia total");
        assertEquals(100.0f, reunionBase.obtenerPorcentajeAsistencia(), 0.01f, "El porcentaje de asistencia debe ser 100%");
    }

    @Test
    public void testReunionSoloConInvitadosExternos() throws InterruptedException {
        Invitado_Externo externo1 = new Invitado_Externo("Luis", "Rojas", "luis@uch.cl");
        Invitado_Externo externo2 = new Invitado_Externo("Maria", "Paz", "maria@uch.cl");

        reunionBase.registrarInvitacion(externo1);
        reunionBase.registrarInvitacion(externo2);
        reunionBase.iniciar();

        reunionBase.registrarAsistencia(externo1);
        Thread.sleep(5000);
        reunionBase.registrarAsistencia(externo2);
        reunionBase.registrarAusencia();

        assertEquals(2, reunionBase.obtenerTotalAsistencia(), "Debe contar a ambos externos");
        assertEquals(1, reunionBase.obtenerRetraso().size(), "Debe identificar al externo retrasado");
        assertEquals(100.0f, reunionBase.obtenerPorcentajeAsistencia(), 0.01f, "El porcentaje debe ser 100%");
    }

    //Casos extremos//

    @Test
    public void testReunionCeroMinutos(){
        reunionBase.registrarInvitacion(invitado1);
        reunionBase.iniciar();
        reunionBase.finalizar();

        float tiempoEnMinutos = reunionBase.calcularTiempoReal();
        assertEquals(0.0f, tiempoEnMinutos, 0.001f, "Una reunion instantanea debe registrar 0 minutos");
    }
}

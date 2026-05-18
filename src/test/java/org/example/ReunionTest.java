package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

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

}

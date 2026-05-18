package org.example;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Departamento informatica =
                new Departamento("Informatica", new ArrayList<>());
        Empleado empleado1 =
                new Empleado("1", "Alvaro", "Anabalon", "alvaro@gmail.com", informatica);
        Empleado empleado2 =
                new Empleado("2", "Martin", "Perez", "martin@gmail.com", informatica);
        Empleado empleado3=
                new Empleado("3","susana","horia","susana@gmail.com", informatica);
        informatica.agregarEmpleado(empleado1);
        informatica.agregarEmpleado(empleado2);
        informatica.agregarEmpleado(empleado3);
        ReunionVirtual reunion =
                new ReunionVirtual("zoom.com/reunion", TipoReunion.TECNICA, empleado1, LocalDate.now(), Duration.ofHours(2));
        reunion.registrarInvitacion(empleado1);
        reunion.registrarInvitacion(empleado2);
        reunion.registrarInvitacion(empleado3);
        System.out.println();
        reunion.iniciar();
        reunion.registrarAsistencia(empleado1);
        Thread.sleep(130000);
        reunion.registrarAsistencia(empleado3);
        System.out.println();
        reunion.agregarNota("buenos dias norteamerica");
        reunion.registrarAusencia();
        reunion.finalizar();

        reunion.generarInforme();
        System.out.println(informatica);
        System.out.println("\nTipo de reunion:");
        System.out.println(reunion.getTipoReunion());

    }
}
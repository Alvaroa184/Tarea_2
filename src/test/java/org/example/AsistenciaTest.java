package org.example;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AsistenciaTest {

    @Test
    public void testCrearAsistencia() {

        Departamento ventas =
                new Departamento("Ventas", new ArrayList<>());

        Empleado empleado =
                new Empleado(
                        "001",
                        "Carlos",
                        "Perez",
                        "carlos@udec.cl",
                        ventas
                );

        Instant hora = Instant.now();

        Asistencia asistencia =
                new Asistencia(
                        empleado,
                        hora
                );

        assertEquals(empleado, asistencia.getInvitable());
        assertEquals(hora, asistencia.getHora());
    }

    @Test
    public void testModificarHoraAsistencia() {

        Departamento ventas =
                new Departamento("Ventas", new ArrayList<>());

        Empleado empleado =
                new Empleado(
                        "001",
                        "Carlos",
                        "Perez",
                        "carlos@udec.cl",
                        ventas
                );

        Instant hora1 = Instant.now();

        Asistencia asistencia =
                new Asistencia(
                        empleado,
                        hora1
                );

        Instant hora2 =
                hora1.plusSeconds(60);

        asistencia.setHora(hora2);

        assertEquals(hora2, asistencia.getHora());
    }

    @Test
    public void testToStringAsistencia() {

        Departamento ventas =
                new Departamento("Ventas", new ArrayList<>());

        Empleado empleado =
                new Empleado(
                        "001",
                        "Carlos",
                        "Perez",
                        "carlos@udec.cl",
                        ventas
                );

        Asistencia asistencia =
                new Asistencia(
                        empleado,
                        Instant.now()
                );

        assertNotNull(asistencia.toString());
    }
}
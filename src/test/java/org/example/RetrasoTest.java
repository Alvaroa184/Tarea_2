package org.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RetrasoTest {

    @Test
    public void testCrearRetraso() {

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

        Instant horaInicio = Instant.now();

        Instant horaLlegada =
                horaInicio.plusSeconds(300);

        Retraso retraso =
                new Retraso(
                        empleado,
                        horaLlegada,
                        horaInicio
                );

        assertEquals(
                5,
                retraso.getTiemporetraso().toMinutes()
        );
    }

    @Test
    public void testToStringRetraso() {

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

        Instant horaInicio = Instant.now();

        Instant horaLlegada =
                horaInicio.plusSeconds(300);

        Retraso retraso =
                new Retraso(
                        empleado,
                        horaLlegada,
                        horaInicio
                );

        assertNotNull(retraso.toString());
    }
}
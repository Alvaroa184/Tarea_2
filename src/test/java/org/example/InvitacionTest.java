package org.example;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InvitacionTest {

    @Test
    public void testCrearInvitacion() {

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

        Invitacion invitacion =
                new Invitacion(empleado);

        assertEquals(
                empleado,
                invitacion.getInvitable()
        );

        assertNotNull(
                invitacion.getHora()
        );
    }

    @Test
    public void testModificarHoraInvitacion() {

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

        Invitacion invitacion =
                new Invitacion(empleado);

        Instant nuevaHora =
                Instant.now().plusSeconds(60);

        invitacion.setHora(nuevaHora);

        assertEquals(
                nuevaHora,
                invitacion.getHora()
        );
    }

    @Test
    public void testToStringInvitacion() {

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

        Invitacion invitacion =
                new Invitacion(empleado);

        assertNotNull(
                invitacion.toString()
        );
    }
}
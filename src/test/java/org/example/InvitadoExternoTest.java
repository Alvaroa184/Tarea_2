package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvitadoExternoTest {

    @Test
    public void testCrearInvitadoExterno() {

        Invitado_Externo invitado =
                new Invitado_Externo(
                        "Juan",
                        "Perez",
                        "juan@gmail.com"
                );

        assertEquals("Juan", invitado.getNombre());
        assertEquals("Perez", invitado.getApellidos());
        assertEquals("juan@gmail.com", invitado.getCorreo());
    }

    @Test
    public void testModificarNombre() {

        Invitado_Externo invitado =
                new Invitado_Externo(
                        "Juan",
                        "Perez",
                        "juan@gmail.com"
                );

        invitado.setNombre("Pedro");

        assertEquals("Pedro", invitado.getNombre());
    }

    @Test
    public void testModificarApellidos() {

        Invitado_Externo invitado =
                new Invitado_Externo(
                        "Juan",
                        "Perez",
                        "juan@gmail.com"
                );

        invitado.setApellidos("Gonzalez");

        assertEquals("Gonzalez", invitado.getApellidos());
    }

    @Test
    public void testModificarCorreo() {

        Invitado_Externo invitado =
                new Invitado_Externo(
                        "Juan",
                        "Perez",
                        "juan@gmail.com"
                );

        invitado.setCorreo("nuevo@gmail.com");

        assertEquals("nuevo@gmail.com", invitado.getCorreo());
    }
}
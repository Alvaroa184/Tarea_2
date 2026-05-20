package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InformeReunionTest {

    private Departamento ventas;
    private Empleado organizador;
    private Empleado invitado1;
    private ReunionVirtual reunionBase;

    @BeforeEach
    public void prepararEntorno() {

        ventas = new Departamento("Ventas", new ArrayList<>());

        organizador = new Empleado(
                "001",
                "Carlos",
                "Perez",
                "carlos@udec.cl",
                ventas
        );

        invitado1 = new Empleado(
                "002",
                "Ana",
                "Gomez",
                "ana@udec.cl",
                ventas
        );

        reunionBase = new ReunionVirtual(
                "meet.google",
                TipoReunion.TECNICA,
                organizador,
                LocalDate.now().plusDays(1),
                Duration.ofHours(2)
        );
    }

    @Test
    public void testGenerarInforme() {

        reunionBase.registrarInvitacion(invitado1);

        reunionBase.iniciar();

        reunionBase.registrarAsistencia(invitado1);

        reunionBase.agregarNota("Nota de prueba");

        reunionBase.finalizar();

        assertDoesNotThrow(() -> {
            reunionBase.generarInforme();
        });
    }
}
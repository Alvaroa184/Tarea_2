package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {

    @Test
    public void testDepartamentoSinEmpleados() {

        Departamento ventas =
                new Departamento("Ventas", new ArrayList<>());

        assertEquals(0, ventas.obtenerCantidadEmpleados());
    }

    @Test
    public void testAgregarEmpleadoDepartamento() {

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

        ventas.agregarEmpleado(empleado);

        assertEquals(1, ventas.obtenerCantidadEmpleados());
    }

    @Test
    public void testCantidadEmpleados() {

        Departamento ventas =
                new Departamento("Ventas", new ArrayList<>());

        Empleado empleado1 =
                new Empleado(
                        "001",
                        "Carlos",
                        "Perez",
                        "carlos@udec.cl",
                        ventas
                );

        Empleado empleado2 =
                new Empleado(
                        "002",
                        "Ana",
                        "Gomez",
                        "ana@udec.cl",
                        ventas
                );

        ventas.agregarEmpleado(empleado1);
        ventas.agregarEmpleado(empleado2);

        assertEquals(2, ventas.obtenerCantidadEmpleados());
    }
}
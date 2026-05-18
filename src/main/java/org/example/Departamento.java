package org.example;
import java.util.List;

public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado>empleados;
    public Departamento(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }


    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

   public void setNombre(String nombre){
       this.nombre = nombre;
   }
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Departamento:\n" +"nombre: "+nombre+"\n"+"cantidad de empleados: "+obtenerCantidadEmpleados()+"\n";
    }

    @Override
    public void invitar() {
        for(Empleado empleado : empleados) {
            System.out.println("Invitando a:"+empleado.getNombre()+" "+empleado.getApellidos());
            System.out.println("Correo:"+empleado.getCorreo());
        };
    }

}

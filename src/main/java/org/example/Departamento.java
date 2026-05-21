package org.example;
import java.util.List;

/**
 * Area especifica de la empresa junto a sus trabajadores
 */
public class Departamento implements Invitable {
    private String nombre;
    private List<Empleado>empleados;

    /**
     * Construye un departamento con su nombre y una lista de sus empleados
     * @param nombre Nombre del departamento
     * @param empleados Lista con los empleados iniciales asociados al departamento
     */
    public Departamento(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    /**
     * Agrega a un nuevo empleado a la lista del departamento
     * @param empleado Empleado que se incorpora al departamento
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    /**
     * Devuelve el tamaño del departemento
     * @return El numero del total de empleados en el departamento
     */
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

package org.example;

/**
 * Representa a un trabajador interno de la empresa y su departamento especifico
 */
public class Empleado implements Invitable {
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Departamento departamento;

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Empleado\n"+ "id:" +id+"\n"+ "Nombre: " +nombre + " " + apellidos+"\n"+"Correo: "+correo+"\n"+"Departamento: "+departamento.getNombre();
    }

    @Override
    public void invitar() {
       System.out.println(toString());
    }

    /**
     * Crea el registro del empleado con sus vinculaciones
     * @param id Codigo identificador del empleado
     * @param nombre Nombre del empleado
     * @param apellido Apellidos del empleado
     * @param correo Correo del empleado
     * @param departamento Departamento al que pertenece el empleado
     */
    public Empleado(String id, String nombre, String apellido, String correo,Departamento departamento) {
        if (nombre==null || nombre.trim().isEmpty() || apellido==null || apellido.trim().isEmpty()) {
            throw new DatoInvalidoException("El nombre y el apellido del empleado no pueden estar vacios");
        }
        if (correo==null || !correo.contains("@")) {
            throw new DatoInvalidoException("El correo del empleado debe contener un '@'");
        }
        if (id==null || id.trim().isEmpty()) {
            throw new DatoInvalidoException("El id del empleado no puede estar vacio");
        }

        this.departamento = departamento;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.correo = correo;
    }
}

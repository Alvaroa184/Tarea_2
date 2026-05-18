package org.example;

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

    public Empleado(String id, String nombre, String apellido, String correo,Departamento departamento) {
        this.departamento = departamento;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.correo = correo;
    }
}

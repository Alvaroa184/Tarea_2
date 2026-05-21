package org.example;

/**
 * Representa a una persona externa a la empresa que ha sido invitada a una reunion
 * Almacena sus datos de contacto como nombre, apellidos y correo
 */
public class Invitado_Externo implements Invitable {
    private String nombre;
    private String apellidos;
    private String Correo;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    public String getCorreo() {
        return Correo;
    }

    /**
     * Almacena los datos del invitado externo para hacerlo invitable para una reunion
     * @param nombre Nombre del invitado externo
     * @param apellidos Apellidos del invitado externo
     * @param Correo Correo del invitado externo
     */
    public Invitado_Externo(String nombre, String apellidos, String Correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.Correo = Correo;
    }
    @Override
    public String toString() {
        return "Nombre: "+ nombre + " " + apellidos + "\n"+ "Correo: "+Correo ;
    }
	@Override
	public void invitar() {
		System.out.println("Invitado Externo");
        System.out.println(toString());
	}
}

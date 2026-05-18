package org.example;
import java.time.*;
public class Nota {
    private String contenido;
    private Instant hora;
    public Nota(String contenido) {
        this.contenido = contenido;
        this.hora = Instant.now();
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Instant getHora() {
        return hora;
    }
    public void setHora(Instant hora) {
        this.hora = hora;
    }
    @Override
    public String toString() {
        return "se ha escrito una nota: "+contenido +"\n"+"a las: "+hora;
    }

}

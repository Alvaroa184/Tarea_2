package org.example;
import java.time.*;

/**
 * Almacena apuntes, observaciones o acuerdos tomados durante el desarrollo de una reunion
 * Registra el instante en que se registro
 */
public class Nota {
    private String contenido;
    private Instant hora;

    /**
     * Crea una nota de texto asignandole el contenido y capturando la hora en que se realizo
     * @param contenido Texto descriptivo de la anotacion realizada
     */
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

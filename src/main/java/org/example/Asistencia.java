package org.example;
import java.time.*;

/**
 * Almacena el registro de asistencia de un participante en una reunion
 * Con su hora de llegada
 */
public class Asistencia {
    private Invitable invitable;
    private Instant hora;

    /**
     * Inicializa un registro de asistencia vinculando al participante y su hora de llegada
     * @param invitable Persona que asiste a la reunion
     * @param hora Hora en la que el participante registra su llegada
     */
    public Asistencia(Invitable invitable, Instant hora) {
        this.invitable = invitable;
        this.hora = hora;
    }
    public Invitable getInvitable() {
        return invitable;
    }
    public void setInvitable(Invitable invitable) {
        this.invitable = invitable;
    }
    public Instant getHora() {
        return hora;
    }
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Asistencia\n"+invitable+"\n"+"hora: "+hora+"\n";
    }
}

package org.example;

import java.time.Instant;

/**
 * Registra a quien realizo la invitacion y en instante en que se realizo
 */
public class Invitacion {
    private Instant hora;
    private Invitable invitable;

    /**
     * Genera un registro de invitacion y la hora a la que se realizo
     * @param invitable Persona invitada a la reunion
     */
    public Invitacion(Invitable invitable) {
        this.invitable = invitable;
        this.hora = Instant.now();
    }
    public Instant getHora() {
        return hora;
    }
    public void setHora(Instant hora) {
        this.hora = hora;
    }
    public Invitable getInvitable() {
        return invitable;
    }
    public void setInvitable(Invitable invitable) {
        this.invitable = invitable;
    }
    @Override
    public String toString() {
        return "Se ha invitado a;"+"\n"+invitable+"\n"+"hora: "+hora+"\n";
    }

}


package org.example;

import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Invitable invitable;
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


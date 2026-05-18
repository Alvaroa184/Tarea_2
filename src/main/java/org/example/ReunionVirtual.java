package org.example;

import java.time.Duration;
import java.time.LocalDate;

public class ReunionVirtual extends Reunion {
    private String enlace;

    public String getEnlace() {
        return enlace;
    }
    public void setEnlace(String enlace) {
     this.enlace = enlace;
    }
    public ReunionVirtual(String enlace, TipoReunion tipo, Empleado organizador, LocalDate fecha, Duration duracionprevista) {
        super(tipo, organizador,fecha,duracionprevista);
        this.enlace = enlace;

    }
    @Override
    public String toString() {
        return "Reunion virutal\n"+"enlace: "+enlace+"\n"+super.toString();
    }
}

package org.example;

import java.time.Duration;
import java.time.LocalDate;

public class ReunionPresencial extends Reunion {
    private String sala;

    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }
    public ReunionPresencial(String sala, TipoReunion tipo, Empleado organizador, LocalDate fecha, Duration duracionprevista) {
        super(tipo,organizador,fecha,duracionprevista);
        this.sala = sala;
    }
    @Override
    public String toString() {
        return "Reunion presencial\n"+ "sala: " + sala + "\n"+super.toString();
    }
}

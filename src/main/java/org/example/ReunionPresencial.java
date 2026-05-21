package org.example;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Reunion que se realiza de modo presencial dentro de las instalaciones de la empresa
 * Adjunta sala en la que se realizara la reunion
 */
public class ReunionPresencial extends Reunion {
    private String sala;

    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Inicializa una reunion presencial asignandole una sala fisica y los atributos base de planificacion
     * @param sala Nombre de la sala en la que se realizara
     * @param tipo Clasificacion tematica de la reunion
     * @param organizador Empleado que organiza la reunion
     * @param fecha Dia planificado para la reunion
     * @param duracionprevista Tiempo previsto para la reunion
     */
    public ReunionPresencial(String sala, TipoReunion tipo, Empleado organizador, LocalDate fecha, Duration duracionprevista) {
        super(tipo,organizador,fecha,duracionprevista);
        this.sala = sala;
    }
    @Override
    public String toString() {
        return "Reunion presencial\n"+ "sala: " + sala + "\n"+super.toString();
    }
}

package org.example;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Reunion que se realiza de modo virtual mediante una enlace a una videollamada
 * Adjunta enlace en la que se realizara la reunion
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    public String getEnlace() {
        return enlace;
    }
    public void setEnlace(String enlace) {
     this.enlace = enlace;
    }

    /**
     * Inicializa una reunion virtual asignandole un enlace y los atributos base de planificacion
     * @param enlace Dirección URL o vinculo de acceso a la videollamada
     * @param tipo Clasificacion tematica de la reunion
     * @param organizador Empleado que organiza la reunion
     * @param fecha Dia planificado para la reunion
     * @param duracionprevista Tiempo previsto para la reunion
     */
    public ReunionVirtual(String enlace, TipoReunion tipo, Empleado organizador, LocalDate fecha, Duration duracionprevista) {
        super(tipo, organizador,fecha,duracionprevista);
        this.enlace = enlace;

    }
    @Override
    public String toString() {
        return "Reunion virutal\n"+"enlace: "+enlace+"\n"+super.toString();
    }
}

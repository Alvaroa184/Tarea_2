package org.example;

import java.time.*;

/**
 * Almacena el registro de los asistentes que llegaron tarde
 */
public class Retraso extends Asistencia {
    private Duration tiemporetraso;

    /**
     * Registro de retraso calculando el tiempo de retraso
     * @param invitable Persona que llega tarde
     * @param horallegada Marca de tiempo en la que el participante ingresa
     * @param horaLimiteLlegada Marca de tiempo a la que se puede llegar sin considerarse retraso
     */
public Retraso(Invitable invitable, Instant horallegada, Instant horaLimiteLlegada) {
    super(invitable,horallegada);
    tiemporetraso = Duration.between(horaLimiteLlegada, horallegada).abs();
}

public Duration getTiemporetraso() {
    return tiemporetraso;

}
public void setTiemporetraso(Duration tiemporetraso) {
    this.tiemporetraso = tiemporetraso;
}

@Override
    public String toString(){
    return "ha llegado: "+getInvitable() +"\n"+"hora: "+getHora()+"\n"+"con un retraso de: "+tiemporetraso.toMinutes()+"\n";
}



}

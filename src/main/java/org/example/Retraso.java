package org.example;

import java.time.*;

public class Retraso extends Asistencia {
    private Duration tiemporetraso;

public Retraso(Invitable invitable, Instant horallegada, Instant horainicio) {
    super(invitable,horallegada);
    tiemporetraso = Duration.between(horainicio, horallegada).abs();
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

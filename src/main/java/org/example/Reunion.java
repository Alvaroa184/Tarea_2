package org.example;
import java.time.*;
import java.util.*;
import java.io.*;

public abstract class Reunion {
    private LocalDate fecha;
    private Duration duracionPrevista;
    private Instant horainicio;
    private Instant horafin;
    private List<Asistencia> asistencias;
    private List<Invitable> ausencias;
    private List<Retraso>  retrasos;
    private List<Invitacion> invitaciones;
    private List<Nota> notas;
    private Empleado organizador;
    private TipoReunion tipo;

    public List<Asistencia> obtenerAsistencia(){
     return asistencias;
    }
    public List <Invitable> obtenerAusencia(){
    return ausencias;
    }
    public List<Retraso> obtenerRetraso(){
    return retrasos;
    }
    public List<Invitacion> obtenerInvitaciones(){return invitaciones;}
    public List<Nota> obtenerNotas(){return notas;}
    public Reunion(TipoReunion tipo,Empleado organizador,LocalDate fecha,Duration duracionPrevista) {
        if (duracionPrevista==null || duracionPrevista.isNegative() || duracionPrevista.isZero()) {
            throw new DuracionInvalidaException("La duracion prevista de la reunion debe ser mayor a cero");
        }
        if (fecha==null || fecha.isBefore(LocalDate.now())) {
            throw new DatoInvalidoException("La fecha de la reunion no puede ser en el pasado");
        }

        this.fecha=fecha;
        this.duracionPrevista=duracionPrevista;
        this.organizador = organizador;
        this.tipo=tipo;
        asistencias = new ArrayList<>();
        ausencias = new ArrayList<>();
        retrasos = new ArrayList<>();
        invitaciones = new ArrayList<>();
        notas = new ArrayList<>();
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    public Duration getDuracionprevista(){
        return duracionPrevista;
    }
    public void setDuracionPrevista(Duration duracionPrevista){

        this.duracionPrevista = duracionPrevista;
    }
    public Empleado getOrganizador() {
        return organizador;
    }
    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }
    public TipoReunion getTipoReunion(){
        return tipo;
    }
    public void setTipoReunion(TipoReunion tipoReunion){
        this.tipo = tipoReunion;
    }
    public void registrarAsistencia(Invitable invitable){
        if (horainicio == null) {
            throw new ReunionNoinicializadaException("La reunion no ha iniciado");
        }
        Instant horallegada = Instant.now();
        boolean invitado = false;
        for(int i = 0; i < invitaciones.size(); i++){
            if(invitaciones.get(i).getInvitable().equals(invitable)){
                invitado = true;
                break;
            }
        }
        if(!invitado){
            throw new InvitadoNoinvitadoException("El invitado no esta registrado");
        }
        for(int i = 0; i < asistencias.size(); i++){
            if(asistencias.get(i).getInvitable().equals(invitable)){
                throw new AsistenciaDuplicadaException("La asistencia ya fue registrada");
            }
        }
        Asistencia a= new Asistencia(invitable,horallegada);
        asistencias.add(a);
        if(horallegada.isAfter(horainicio)){
            Retraso ret = new Retraso(invitable,horallegada,horainicio);
            retrasos.add(ret);
        }

    }
    public void registrarInvitacion(Invitable invitable){
        for(int i = 0; i < invitaciones.size(); i++){
            if(invitaciones.get(i).getInvitable().equals(invitable)){
                throw new InvitacionDuplicadaException("El invitado ya fue registrado");
            }
        }
        Invitacion invi = new Invitacion(invitable);
        invitaciones.add(invi);
        invitable.invitar();
    }

    public void agregarNota(String contenido){
        Nota n = new Nota(contenido);
        notas.add(n);

    }
public void registrarAusencia(){
        if(horainicio!=null){
        for(int i=0;i<invitaciones.size();i++){
            boolean asistencia=false;
            for(int j=0;j<asistencias.size();j++){
                if(invitaciones.get(i).getInvitable().equals(asistencias.get(j).getInvitable())){
                    asistencia=true;
                    break;
                }

            }
            if(!asistencia){
                ausencias.add((Invitable) invitaciones.get(i).getInvitable());
            }
        }}
}
    public int obtenerTotalAsistencia(){
        int gente= asistencias.size();
        return gente ;
    }
    public float obtenerPorcentajeAsistencia(){
        float total= asistencias.size()+ausencias.size();
        if(total==0){
            return 0;
        }
        float porcentaje= ((float)asistencias.size()/total)*100;
    return porcentaje;
    }
    public float calcularTiempoReal(){
        if(horainicio==null||horafin==null){
            throw new ReunionNoFinalizadaException("La reunion no ha iniciado o no ha finalizado");
        }

        Duration tiempo= Duration.between(horainicio, horafin);

        //Cambio de tiempo.toHours() a (float) tiempo.toMillis() / 60000.0f para que las reuniones que duren menos de una hora no las tome como 0//
        float tiempo_reunion= (float) tiempo.toMillis() / 60000.0f; //Tiempo en minutos//

        return tiempo_reunion;
    }
    public void iniciar(){
       if(horainicio!=null){
           throw new ReunionYainiciadaException("La reunion ya fue iniciada");
       }
       if(invitaciones.isEmpty()){
           throw new SininvitadosException("Las invitaciones no pueden estar vacia");
       }
        horainicio=Instant.now();
    }
    public void finalizar(){
      if(horafin!=null){
          throw new ReunionYaFinalizadaException("La reunion ya fue finalizada");
      }
      else if(horainicio==null){
          throw new ReunionNoinicializadaException("la reunion nunca fue iniciada");
      }
        horafin=Instant.now();
    }
    @Override
    public String toString(){
        return  "tipo: "+ tipo+"\n"+"organizador: "+organizador+"\n"+"fecha: "+fecha+"\n"+"duracion prevista: "+duracionPrevista+"\n"+"Hora de inicio: "+ horainicio+ "\n"
                + "hora de fin: " + horafin+ "\n" + "asistencias: "+ asistencias+ "\n" + "retrasos: "+ retrasos+ "\n" + "ausencias: "+ ausencias+ "\n"+ "invitaciones: "+ invitaciones+ "\n" + "notas: "+ notas+"\n";
    }
    public void generarInforme(){
        try{
            FileWriter writer=new FileWriter("informe.txt");
            writer.write(toString());
            writer.close();
        }catch(IOException e){
            System.out.println("Error");

        }
    }
}

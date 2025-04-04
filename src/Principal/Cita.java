package Principal;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 */
public class Cita {

    public int id;
    public String nombreSala;
    public LocalDate fecha;
    public LocalTime hora;
    public String dniRecepcionista;


    public Cita() {
    }

    /**
     * @param id
     * @param nombreSala
     * @param fecha
     * @param hora
     * @param dniRecep
     */
    public Cita(int id, String nombreSala, LocalDate fecha, LocalTime hora, String dniRecep) {
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDniRecepcionista() {
        return dniRecepcionista;
    }

    public void setDniRecepcionista(String dniRecepcionista) {
        this.dniRecepcionista = dniRecepcionista;
    }


    public String citaToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <nombre_sala>").append(nombreSala).append("</nombre_sala>")
                .append("      <fecha>").append(fecha).append("</fecha>")
                .append("      <hora>").append(hora).append("</hora>")
                .append("      <dniRecepcionista>").append(dniRecepcionista).append("</dniRecepcionista>");
        return xmlBuilder.toString();
    }

    public String citaToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"id\": \"").append(id).append("\", ")
                .append("\"nombre_sala\": \"").append(nombreSala).append("\", ")
                .append("\"fecha\": \"").append(fecha).append("\", ")
                .append("\"hora\": \"").append(hora).append("\", ")
                .append("\"dniRecepcionista\": \"").append(dniRecepcionista).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
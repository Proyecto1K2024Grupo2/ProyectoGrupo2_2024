package Principal;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase Cita que necesita una Sala, y el DNI del empleado el cual va a tratar al animal.
 * Sirve para tener registro de quien la ha asignado, donde ha ocurrido y se conecta con historial para tener más información que puede ser útil en un futuro.
 */
public class Cita {

    public int id;
    public String nombreSala;
    public LocalDate fecha;
    public LocalTime hora;
    public String dniRecepcionista;

    /**
     * Constructor por defecto de la clase Cita.
     */
    public Cita() {
    }

    /**
     * Constructor de Cita que permite crear una instancia de cita.
     * @param nombreSala Nombre de la sala donde ha ocurrido la cita.
     * @param fecha Fecha de la cita.
     * @param hora Hora de la cita.
     * @param dniRecepcionista DNI del recepcionista que ha asignado la cita.
     */
    public Cita(String nombreSala, LocalDate fecha, LocalTime hora, String dniRecepcionista) {
        this.nombreSala = nombreSala;
        this.fecha = fecha;
        this.hora = hora;
        this.dniRecepcionista = dniRecepcionista;
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


    /**
     * Convierte los datos de la Cita a XML.
     * @return Devuelve un String con los datos de la Cita a XML.
     */
    public String citaToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <nombre_sala>").append(nombreSala).append("</nombre_sala>")
                .append("      <fecha>").append(fecha).append("</fecha>")
                .append("      <hora>").append(hora).append("</hora>")
                .append("      <dniRecepcionista>").append(dniRecepcionista).append("</dniRecepcionista>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos de la Cita a JSON.
     * @return Devuelve un String con los datos de la Cita a JSON.
     */
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
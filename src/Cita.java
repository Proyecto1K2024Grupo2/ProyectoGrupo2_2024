
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 */
public class Cita {

    public int id;
    public String nombre_sala;
    public LocalDate fecha;
    public LocalTime hora;
    public String dniReceocionista;

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
        // TODO implement here
    }

    /**
     *
     */
    public void añadirCita() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarCita() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarCita() {
        // TODO implement here
    }

    public String citaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <nombre_sala>").append(nombre_sala).append("</nombre_sala")
                .append("      <fecha>").append(fecha).append("</fecha>")
                .append("      <hora>").append(hora).append("</hora>")
                .append("      <dniRecepcionista>").append(dniReceocionista).append("</dniRecepcionista>");
        return xmlBuilder.toString();
    }
}
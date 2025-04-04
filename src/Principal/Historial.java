package Principal;

public class Historial {

    private int id_cita;
    private int id_animal;
    private int id_tratamiento;

    /**
     * @param idCita
     * @param idAnimal
     * @param idTratamiento
     */
    public Historial(int idCita, int idAnimal, int idTratamiento) {
        // TODO implement here
    }

    //Getters y Setters
    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }


    public String historialToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id_cita>").append(id_cita).append("</id_cita>")
                .append("      <id_animal>").append(id_animal).append("</id_animal>")
                .append("      <id_tratamiento>").append(id_tratamiento).append("</id_tratamiento>");
        return xmlBuilder.toString();
    }

    public String historialToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"id_cita\": \"").append(id_cita).append("\", ")
                .append("\"id_animal\": \"").append(id_animal).append("\", ")
                .append("\"id_tratamiento\": \"").append(id_tratamiento).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
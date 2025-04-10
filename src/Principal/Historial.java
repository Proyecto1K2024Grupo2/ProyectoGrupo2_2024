package Principal;

/**
 * Historial sirve para tener una correlacion entre las clases Cita, Animal y tratamiento.
 * Es útil a nivel de información, ya que se pueden ver por ejemplo, las anteriores citas de un animal en concreto o los tratamientos
 * Cabe recalcar que la información de Historial tiene correlacion entre sí, es decir, que en un registro la información que aparece ha ocurrido de esa manera.
 */
public class Historial {

    private int id_cita;
    private int id_animal;
    private int id_tratamiento;

    /**
     * Constructor de la clase Historial
     * @param id_cita id de la cita
     * @param id_animal id del animal
     * @param id_tratamiento id del tratamiento
     */
    public Historial(int id_cita, int id_animal, int id_tratamiento) {
        this.id_cita = id_cita;
        this.id_animal = id_animal;
        this.id_tratamiento = id_tratamiento;
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


    /**
     * Convierte los datos del historial a XML.
     * @return Devuelve un String con los datos de Historial a XML.
     */
    public String historialToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id_cita>").append(id_cita).append("</id_cita>")
                .append("      <id_animal>").append(id_animal).append("</id_animal>")
                .append("      <id_tratamiento>").append(id_tratamiento).append("</id_tratamiento>");
        return xmlBuilder.toString();
    }


    /**
     * Convierte los datos del historial a JSON.
     * @return Devuelve un String con los datos de Historial a JSON.
     */
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
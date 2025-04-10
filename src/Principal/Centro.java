package Principal;

/**
 * Representa un centro (local físico).
 * A un centro estan asociaciadas las salas de este, sus empleados y las citas.
 */
public class Centro {

    private int cod;
    private String nombreCentro;
    private String direccion;
    private String cp;

    //Constructor por defecto

    /**
     * Constructor de la clase Centro el cual te permite crear un centro.
     * @param nombre nombre del centro.
     * @param direccion Dirección del centro.
     * @param cp Código Postal de la zona en la cual se encuentra el centro.
     */
    public Centro(String nombre, String direccion, String cp) {
    }


    //Getters y Setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }


    /**
     * Convierte los datos del centro a XML.
     * @return Devuelve un String con los datos de Centro a XML.
     */
    public String centroToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <codigo>").append(cod).append("</codigo>")
                .append("      <nombre>").append(nombreCentro).append("</nombre")
                .append("      <direccion>").append(direccion).append("</direccion>")
                .append("      <cp>").append(cp).append("</cp>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del centro a JSON.
     * @return Devuelve un String con los datos de Centro a JSON.
     */
    public String centroToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"codigo\": \"").append(cod).append("\", ")
                .append("\"nombre\": \"").append(nombreCentro).append("\", ")
                .append("\"direccion\": \"").append(direccion).append("\", ")
                .append("\"cp\": \"").append(cp).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
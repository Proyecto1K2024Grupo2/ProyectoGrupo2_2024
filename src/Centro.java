public class Centro {

    private int cod;
    private String nombre;
    private String direccion;
    private String cp;

    //Constructor por defecto
    public Centro() {
    }

    /**
     * @param codigo
     * @param nombre
     * @param direccion
     * @param cp
     */
    public Centro(int codigo, String nombre, String direccion, String cp) {
        // TODO implement here
    }

    /**
     *
     */
    public void añadirCentro() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarCentro() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarCentro() {
        // TODO implement here
    }

    public String centroToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <codigo>").append(cod).append("</codigo>")
                .append("      <nombre>").append(nombre).append("</nombre")
                .append("      <direccion>").append(direccion).append("</direccion>")
                .append("      <cp>").append(cp).append("</cp>");
        return xmlBuilder.toString();
    }
}
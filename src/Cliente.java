public class Cliente {

    /**
     * Default constructor
     */
    public Cliente() {
    }


    /**
     *
     */
    private String dni;

    /**
     *
     */
    private String nombre;

    /**
     *
     */
    private int telefono;

    /**
     * @param dni
     * @param nombre
     * @param telef
     */
    public Cliente(String dni, String nombre, int telef) {
        // TODO implement here
    }

    /**
     *
     */
    public void añadirCliente() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarCliente() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarCliente() {
        // TODO implement here
    }

    public String clienteToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>");
        return xmlBuilder.toString();
    }

    public String clienteToJSON() {
        return "{"
                + "\"dni\":\"" + dni + "\","
                + "\"nombre\":\"" + nombre + "\","
                + "\"telefono\":\"" + telefono + "\""
                + "}";
    }

}
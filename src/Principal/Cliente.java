package Principal;

public class Cliente {
    private String dniCliente;
    private String nombreCliente;
    private int telefono;

    /**
     * Default constructor
     */
    public Cliente() {
    }

    /**
     * @param dni
     * @param nombre
     * @param telef
     */
    public Cliente(String dni, String nombre, int telef) {
        // TODO implement here
    }

    //Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
        xmlBuilder.append("      <dni>").append(dniCliente).append("</dni>")
                .append("      <nombre>").append(nombreCliente).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>");
        return xmlBuilder.toString();
    }

    public String clienteToJSON() {
        return "{"
                + "\"dni\":\"" + dniCliente + "\","
                + "\"nombre\":\"" + nombreCliente + "\","
                + "\"telefono\":\"" + telefono + "\""
                + "}";
    }

}
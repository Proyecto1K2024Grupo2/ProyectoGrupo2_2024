public class Empleado {

    protected String dni;
    protected String nombre;
    protected int telefono;
    protected String numCuenta;
    protected double sueldo;


    /**
     * @param dni
     * @param nombre
     * @param telefono
     * @param numCuenta
     * @param sueldo
     */
    public Empleado(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.numCuenta = numCuenta;
        this.sueldo = sueldo;
    }

    /**
     *
     */
    public void añadirEmpleado() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarEmpleado() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarEmpleado() {
        // TODO implement here
    }

    /**
     *
     */
    public void Operation1() {
        // TODO implement here
    }

    public String empleadoToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    public String empleadoToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"dni\": \"").append(dni).append("\", ")
                .append("\"nombre\": \"").append(nombre).append("\", ")
                .append("\"telefono\": \"").append(telefono).append("\", ")
                .append("\"numCuenta\": \"").append(numCuenta).append("\", ")
                .append("\"sueldo\": ").append(sueldo)
                .append("}");
        return jsonBuilder.toString();
    }



}
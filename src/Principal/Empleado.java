package Principal;

public class Empleado {

    protected String dniEmpleado;
    protected String nombreEmpleado;
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
        this.dniEmpleado = dni;
        this.nombreEmpleado = nombre;
        this.telefono = telefono;
        this.numCuenta = numCuenta;
        this.sueldo = sueldo;
    }

    //Getters y Setters


    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
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
        xmlBuilder.append("      <dni>").append(dniEmpleado).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    public String empleadoToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"dni\": \"").append(dniEmpleado).append("\", ")
                .append("\"nombre\": \"").append(nombreEmpleado).append("\", ")
                .append("\"telefono\": \"").append(telefono).append("\", ")
                .append("\"numCuenta\": \"").append(numCuenta).append("\", ")
                .append("\"sueldo\": ").append(sueldo)
                .append("}");
        return jsonBuilder.toString();
    }



}
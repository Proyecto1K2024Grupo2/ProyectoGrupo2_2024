package Principal;

/**
 * Cirujano es un tipo de empleado por lo que empleado es su clase padre y cirujano hereda sus atributos.
 * Un cirujano puede operar a los animales, por lo cual tiene relación con Cita y con Centro.
 * {@link Empleado}
 */
public class Cirujano extends Empleado {
    private String dni;

    /**
     * Constructor de la clase cirujano la cual todos los datos que necesita son heredados por Empleado.
     * @param dni Dni del empleado.
     * @param nombre Nombre completo del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param numCuenta Número de cuenta bancaria del empleado.
     * @param sueldo Sueldo mensual del empleado.
     */
    public Cirujano(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        super(dni, nombre, telefono, numCuenta, sueldo);
    }

    //Getters y Setters
    public String getDniEmpleado() {
        return dni;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dni = dniEmpleado;
    }

    /**
     * Convierte los datos del cirujano a XML.
     * @return Devuelve un String con los datos de Cirujano a XML.
     */
    public String cirujanoToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del cirujano a JSON.
     * @return Devuelve un String con los datos de Cirujano a JSON.
     */
    public String cirujanoToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"dni\": \"").append(dni).append("\", ")
                .append("\"nombre\": \"").append(nombreEmpleado).append("\", ")
                .append("\"telefono\": \"").append(telefono).append("\", ")
                .append("\"numCuenta\": \"").append(numCuenta).append("\", ")
                .append("\"sueldo\": ").append(sueldo)
                .append("}");
        return jsonBuilder.toString();
    }

}
package Principal;

/**
 * La clase Cuidador es un tipo de empleado por lo que es hijo de Empleado y hereda sus atributos.
 * Un cuidador puede cuidar a los animales.
 * {@link Empleado}
 */
public class Cuidador extends Empleado {
    private String dni;
    /**
     * Constructor de la clase Cuidador la cual todos los datos que necesita son heredados por Empleado.
     * @param dni Dni del empleado.
     * @param nombre Nombre completo del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param numCuenta Número de cuenta bancaria del empleado.
     * @param sueldo Sueldo mensual del empleado.
     */
    public Cuidador(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        super(dni, nombre, telefono, numCuenta, sueldo);
    }

    //Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    /**
     * Convierte los datos del Cuidador a XML.
     * @return Devuelve un String con los datos de Cuidador a XML.
     */
    public String cuidadorToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dniEmpleado).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del Cuidador a JSON.
     * @return Devuelve un String con los datos de Cuidador a JSON.
     */
    public String cuidadorToJSON() {
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
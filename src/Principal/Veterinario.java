package Principal;

/**
 * Veterinario es un tipo de empleado por lo que Empleado es su clase padre y Veterinario hereda sus atributos.
 * Un veterinario proporciona tratamientos a los animales y ofrecer posologías o medicinas.
 * {@link Empleado}
 */
public class Veterinario extends Empleado {

    /**
     * Constructor de la clase Veterinario la cual todos los datos que necesita son heredados por Empleado.
     * @param dni Dni del empleado.
     * @param nombre Nombre completo del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param numCuenta Número de cuenta bancaria del empleado.
     * @param sueldo Sueldo mensual del empleado.
     */
    public Veterinario(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        super(dni, nombre, telefono, numCuenta, sueldo);
    }


    /**
     * Convierte los datos del veterinario a XML.
     * @return Devuelve un String con los datos de Veterinario a XML.
     */
    public String veterinarioToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dniEmpleado).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del veterinario a JSON.
     * @return Devuelve un String con los datos de Veterinario a JSON .
     */
    public String veterinarioToJSON() {
        return "{"
                + "\"dni\":\"" + dniEmpleado + "\","
                + "\"nombre\":\"" + nombreEmpleado + "\","
                + "\"telefono\":\"" + telefono + "\","
                + "\"numCuenta\":\"" + numCuenta + "\","
                + "\"sueldo\":\"" + sueldo + "\""
                + "}";
    }
}
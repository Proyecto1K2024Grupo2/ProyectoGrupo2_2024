package Principal;

/**
 * La clase Recepcionista es un tipo de empleado por lo que es hijo de Empleado y hereda sus atributos.
 * Un recepcionista gestiona parte de la información de la BD, por ejemplo, puede añadir clientes, animales, gestionar citas, etc.
 * {@link Empleado}
 */
public class Recepcionista extends Empleado {

    /**
     * Constructor de la clase Recepcionista la cual todos los datos que necesita son heredados por Empleado.
     * @param dni Dni del empleado.
     * @param nombre Nombre completo del empleado.
     * @param telefono Número de teléfono del empleado.
     * @param numCuenta Número de cuenta bancaria del empleado.
     * @param sueldo Sueldo mensual del empleado.
     */
    public Recepcionista(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        super(dni, nombre, telefono, numCuenta, sueldo);
    }


    /**
     * Convierte los datos del recepcionista a XML.
     * @return Devuelve un String con los datos de Recepcionista a XML.
     */
    public String recepcionistaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dniEmpleado).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del recepcionista a JSON.
     * @return Devuelve un String con los datos de Recepcionista a JSON.
     */
    public String recepcionistaToJSON() {
        return "{"
                + "\"dni\":\"" + dniEmpleado + "\","
                + "\"nombre\":\"" + nombreEmpleado + "\","
                + "\"telefono\":\"" + telefono + "\","
                + "\"numCuenta\":\"" + numCuenta + "\","
                + "\"sueldo\":\"" + sueldo + "\""
                + "}";
    }

}
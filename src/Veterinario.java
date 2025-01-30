
public class Veterinario extends Empleado {

    public Veterinario(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        super(dni, nombre, telefono, numCuenta, sueldo);
    }

    /**
     *
     */
    public void asignar() {
        // TODO implement here
    }

    /**
     *
     */
    public void desAsignar() {
        // TODO implement here
    }

    public String veterinarioToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    public String veterinarioToJSON() {
        return "{"
                + "\"dni\":\"" + dni + "\","
                + "\"nombre\":\"" + nombre + "\","
                + "\"telefono\":\"" + telefono + "\","
                + "\"numCuenta\":\"" + numCuenta + "\","
                + "\"sueldo\":\"" + sueldo + "\""
                + "}";
    }
}
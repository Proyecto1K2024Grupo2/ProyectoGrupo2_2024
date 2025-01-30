public class Cuidador extends Empleado {

    public Cuidador(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
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
    public void borrarCuidador() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarCuidador() {
        // TODO implement here
    }

    /**
     *
     */
    public void desAsignar() {
        // TODO implement here
    }

    public String cuidadorToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombre).append("</nombre")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

    public String cuidadorToJSON() {
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
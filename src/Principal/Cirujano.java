package Principal;

public class Cirujano extends Empleado {

    private String dni;

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

    public String cirujanoToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

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
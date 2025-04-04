package Principal;

public class Recepcionista extends Empleado {

    public Recepcionista(String dni, String nombre, int telefono, String numCuenta, double sueldo) {
        super(dni, nombre, telefono, numCuenta, sueldo);
    }


    public String recepcionistaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dniEmpleado).append("</dni>")
                .append("      <nombre>").append(nombreEmpleado).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }

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
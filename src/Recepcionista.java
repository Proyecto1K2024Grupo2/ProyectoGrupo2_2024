
public class Recepcionista extends Empleado {


    public Recepcionista(String dni, String nombre, int telefono, String numCuenta, double sueldo, String dni1) {
        super(dni, nombre, telefono, numCuenta, sueldo);

    }

    /**
     *
     */
    public void Operation1() {
        // TODO implement here
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

    public String recepcionistaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dni).append("</dni>")
                .append("      <nombre>").append(nombre).append("</nombre")
                .append("      <telefono>").append(telefono).append("</telefono>")
                .append("      <numCuenta>").append(numCuenta).append("</numCuenta>")
                .append("      <sueldo>").append(sueldo).append("</sueldo>");
        return xmlBuilder.toString();
    }
}
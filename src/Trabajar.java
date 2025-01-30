public class Trabajar {

    public String dniEmpleado;
    public int codCentro;

    /**
     * Default constructor
     */
    public Trabajar() {
    }


    public String trabajarToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dniEmpleado>").append(dniEmpleado).append("</dniEmpleado>")
                .append("      <codCentro>").append(codCentro).append("</codCentro");
        return xmlBuilder.toString();
    }

    public String trabajarToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"dniEmpleado\": \"").append(dniEmpleado).append("\", ")
                .append("\"codCentro\": \"").append(codCentro).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
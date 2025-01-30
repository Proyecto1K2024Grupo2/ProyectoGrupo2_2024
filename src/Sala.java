
public class Sala {

    private String nombre;
    private int cod_centro;

    //Constructor por defecto
    public Sala() {
    }


    /**
     * @param nombre
     * @param cod
     */
    public Sala(String nombre, int cod) {
        // TODO implement here
    }

    /**
     *
     */
    public void añadirSala() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarSala() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarSala() {
        // TODO implement here
    }

    public String salaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <cod_centro>").append(cod_centro).append("</cod_centro>");
        return xmlBuilder.toString();
    }

    public String salaToJSON() {
        return "{"
                + "\"nombre\":\"" + nombre + "\","
                + "\"cod_centro\":\"" + cod_centro + "\""
                + "}";
    }

}
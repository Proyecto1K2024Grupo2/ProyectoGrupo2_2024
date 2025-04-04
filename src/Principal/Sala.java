package Principal;

public class Sala {

    private String nombre;
    private int codCentro;

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

    //Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodCentro() {
        return codCentro;
    }

    public void setCodCentro(int codCentro) {
        this.codCentro = codCentro;
    }


    public String salaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <cod_centro>").append(codCentro).append("</cod_centro>");
        return xmlBuilder.toString();
    }

    public String salaToJSON() {
        return "{"
                + "\"nombre\":\"" + nombre + "\","
                + "\"cod_centro\":\"" + codCentro + "\""
                + "}";
    }

}
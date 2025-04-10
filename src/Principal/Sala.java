package Principal;

/**
 * La clase Sala hace referencia a una sala de un Centro
 * Sala está relacionada con su centro y tiene información identificativa
 */
public class Sala {

    private String nombre;
    private int codCentro;

    //Constructor por defecto
    public Sala() {
    }




    /**
     * Constructor de Sala
     * @param nombre Nombre de la Sala
     * @param codCentro Código del centro en el que se encuentra la sala
     */
    public Sala(String nombre, int codCentro) {
        this.nombre = nombre;
        this.codCentro = codCentro;
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


    /**
     * Convierte los datos de la sala a XML.
     * @return Devuelve un String con los datos de Sala a XML.
     */
    public String salaToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <cod_centro>").append(codCentro).append("</cod_centro>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos de la sala a JSON.
     * @return Devuelve un String con los datos de Sala a JSON.
     */
    public String salaToJSON() {
        return "{"
                + "\"nombre\":\"" + nombre + "\","
                + "\"cod_centro\":\"" + codCentro + "\""
                + "}";
    }

}
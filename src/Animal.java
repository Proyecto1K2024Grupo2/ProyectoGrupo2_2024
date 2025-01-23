
import java.time.LocalDate;

public class Animal {


    private int id;
    private String dni_cliente;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fnac;

    //Constructor por defecto
    public Animal() {
    }

    /**
     * @param id
     * @param dniCliente
     * @param nombre
     * @param especie
     * @param raza
     * @param fnac
     */
    public Animal(int id, String dniCliente, String nombre, String especie, String raza, LocalDate fnac) {
        // TODO implement here
    }

    /**
     *
     */
    public void añadirAnimal() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarAnimal() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarAnimal() {
        // TODO implement here
    }

    public String animalToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <dni_cliente>").append(dni_cliente).append("</dni_cliente")
                .append("      <nombre>").append(nombre).append("</nombre>")
                .append("      <especie>").append(especie).append("</especie>")
                .append("      <raza>").append(raza).append("</raza>")
                .append("      <fnac>").append(fnac).append("</fnac");
        return xmlBuilder.toString();
    }

}
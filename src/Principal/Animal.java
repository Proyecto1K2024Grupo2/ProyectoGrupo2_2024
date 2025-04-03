package Principal;

import java.sql.Date;
import java.time.LocalDate;

public class Animal {


    private int id;
    private String dni_cliente;
    private String nombreAnimal;
    private String especie;
    private String raza;
    private LocalDate fnac;

    //Constructor por defecto
    public Animal(String dni, String nombre, int telefono) {
    }

    /**
     * @param id
     * @param dniCliente
     * @param nombre
     * @param especie
     * @param raza
     * @param fnac
     */
    public Animal(int id, String dniCliente, String nombre, String especie, String raza, Date fnac) {
        // TODO implement here
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
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

    public String animalToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <dni_cliente>").append(dni_cliente).append("</dni_cliente>")
                .append("      <nombre>").append(nombreAnimal).append("</nombre>")
                .append("      <especie>").append(especie).append("</especie>")
                .append("      <raza>").append(raza).append("</raza>")
                .append("      <fnac>").append(fnac).append("</fnac>");
        return xmlBuilder.toString();
    }

    public String animalToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"id\": \"").append(id).append("\", ")
                .append("\"dni_cliente\": \"").append(dni_cliente).append("\", ")
                .append("\"nombre\": \"").append(nombreAnimal).append("\", ")
                .append("\"especie\": \"").append(especie).append("\", ")
                .append("\"raza\": \"").append(raza).append("\", ")
                .append("\"fnac\": \"").append(fnac).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
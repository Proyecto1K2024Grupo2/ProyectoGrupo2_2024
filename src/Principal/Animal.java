package Principal;

import java.sql.Date;
import java.time.LocalDate;

public class Animal {


    private int id;
    private String dni_cliente;
    private String nombreAnimal;
    private String especie;
    private String raza;
    private Date edad;

    //Constructor por defecto
    public Animal(String dni, String nombre, int telefono) {
    }

    /**
     * @param dniCliente
     * @param nombre
     * @param especie
     * @param raza
     * @param edad
     */
    public Animal(String dniCliente, String nombre, String especie, String raza, Date edad) {
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

    public LocalDate getEdad() {
        return edad.toLocalDate();
    }

    public void setEdad(LocalDate edad) {
        this.edad = Date.valueOf(edad);
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
                .append("      <fnac>").append(edad).append("</fnac>");
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
                .append("\"fnac\": \"").append(edad).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
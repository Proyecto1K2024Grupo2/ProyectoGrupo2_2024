package Principal;

import DB.AnimalDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Representa un animal asociado a un cliente en una base de datos veterinaria.
 * Incluye información como el nombre, especie, raza y fecha de nacimiento.
 */
public class Animal {
    private int id;
    private String dni_cliente;
    private String nombreAnimal;
    private String especie;
    private String raza;
    private Date edad;


    /**
     * Constructor para crear un objeto Animal sin ID (ID se asigna automáticamente).
     *
     * @param dni_cliente  DNI del cliente dueño del animal.
     * @param nombreAnimal Nombre del animal.
     * @param especie      Especie del animal.
     * @param raza         Raza del animal.
     * @param edad         Fecha de nacimiento del animal.
     */
    public Animal(String dni_cliente, String nombreAnimal, String especie, String raza, Date edad) {
        this.dni_cliente = dni_cliente;
        this.nombreAnimal = nombreAnimal;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
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
     * Convierte los datos del animal en formato XML.
     *
     * @return Representación en XML del animal.
     */
    public String animalToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <dni_cliente>").append(dni_cliente).append("</dni_cliente>")
                .append("      <nombre>").append(nombreAnimal).append("</nombre>")
                .append("      <especie>").append(especie).append("</especie>")
                .append("      <raza>").append(raza).append("</raza>")
                .append("      <edad>").append(edad).append("</edad>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del animal en formato JSON.
     *
     * @return Representación en JSON del animal.
     */
    public String animalToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"id\": \"").append(id).append("\", ")
                .append("\"dni_cliente\": \"").append(dni_cliente).append("\", ")
                .append("\"nombre\": \"").append(nombreAnimal).append("\", ")
                .append("\"especie\": \"").append(especie).append("\", ")
                .append("\"raza\": \"").append(raza).append("\", ")
                .append("\"edad\": \"").append(edad).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

    /**
     * Menú principal para gestionar animales mediante consola.
     *
     * @param args Argumentos introducidos por usuario.
     * @throws Exception Si ocurre algún error en la creación o manipulación de animales.
     */
    public static void main(String[] args) throws Exception {
        AnimalDAO animalDAO = new AnimalDAO();
        Scanner sc = new Scanner(System.in);

        int resp = 0;
        do {
            System.out.println("""
                    1. Seleccionar todos los animales
                    2. Seleccionar animal por ID
                    3. Insertar animal
                    4. Actualizar animal
                    5. Borrar animal
                    6. Total animales
                    7. SALIR"""
            );

            try {
                resp = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Opción inválida");
            }

            switch (resp) {
                case 1 -> System.out.println(animalDAO.getAllAnimal());
                case 2 -> animalDAO.getAnimalByID(pedirIdAnimal());
                case 3 -> animalDAO.insertAnimal(crearAnimal());
                case 4 -> animalDAO.updateAnimal(crearAnimal());
                case 5 -> animalDAO.deleteAnimal(pedirIdAnimal());
                case 6 -> animalDAO.totalAnimales();
                case 7 -> System.out.println("Saliendo");
                default -> System.out.println("Opción no válida");
            }
        } while (resp != 7);
    }

    private static int pedirIdAnimal() {
        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = true;
        int id = 0;

        System.out.println("Introduce el ID del animal: ");
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR, formato de ID no válido.");
            ejecucionCorrecta = false;
            throw new RuntimeException(e);
        }

        if (ejecucionCorrecta) {
            return id;
        } else {
            return 0;
        }
    }

    private static Animal crearAnimal() throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean ejecucionCorrecta = true;

        String dni;
        String nombre;
        String especie;
        String raza;
        Date edad;

        System.out.println("Introduce el DNI del dueño del animal: ");
        try {
            dni = sc.next();
            if (!dni.matches("\\d{8}[A-Z]")) {
                ejecucionCorrecta = false;
            }
        } catch (Exception e) {
            System.out.println("ERROR, DNI no válido.");
            ejecucionCorrecta = false;
            throw new RuntimeException(e);
        }

        System.out.println("Introduce el nombre del animal: ");
        try {
            nombre = sc.next();
            if (!nombre.matches(".{0,64}")) {
                System.out.println("ERROR, nombre demasiado largo");
                ejecucionCorrecta = false;
            }
        } catch (Exception e) {
            System.out.println("ERROR, nombre no válido.");
            ejecucionCorrecta = false;
            throw new RuntimeException(e);
        }

        System.out.println("Introduce la especie del animal: ");
        try {
            especie = sc.next();
            if (!especie.matches(".{0,64}")) {
                System.out.println("ERROR, especie demasiado larga");
                ejecucionCorrecta = false;
            }
        } catch (Exception e) {
            System.out.println("ERROR, especie no válida.");
            ejecucionCorrecta = false;
            throw new RuntimeException(e);
        }

        System.out.println("Introduce la raza del animal: ");
        try {
            raza = sc.next();
            if (!raza.matches(".{0,64}")) {
                System.out.println("ERROR, raza demasiado larga");
                ejecucionCorrecta = false;
            }
        } catch (Exception e) {
            System.out.println("ERROR, raza no válida.");
            ejecucionCorrecta = false;
            throw new RuntimeException(e);
        }

        System.out.println("Introduce la fecha de nacimiento del animal: ");
        try {
            edad = Date.valueOf(sc.next(Pattern.compile(
                    "^[0,1]?\\d{1}\\/(([0-2]?\\d{1})|([3][0,1]{1}))\\/(([1]{1}[9]{1}[9]{1}\\d{1})|([2-9]{1}\\d{3}))$")));
        } catch (Exception e) {
            System.out.println("ERROR, fecha no válida (Formato = MM/DD/AAAA.");
            ejecucionCorrecta = false;
            throw new RuntimeException(e);
        }

        if (!ejecucionCorrecta) {
            throw new Exception("No se ha podido crear el animal.");
        }

        Animal animal;
        try {
            animal = new Animal(dni, nombre, especie, raza, edad);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return animal;

    }

}
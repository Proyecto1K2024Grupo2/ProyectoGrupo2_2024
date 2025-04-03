package DB;

import Principal.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase AnimalDAO - Maneja las operaciones de base de datos para la tabla Animal.
 * Implementa métodos CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar los Animales.
 * Implementa el patrón Singleton para gestionar la conexión a la base de datos.
 *
 * @version 01-2025
 * @author Raul Quilez
 */
public class AnimalDAO {
    // Creamos la instancia de AnimalDAO
    private static AnimalDAO instance;
    // Creamos la conexión con la base de datos
    private Connection connection;


    /**
     *  Sentencias básicas para la tabla Animal
     */

    // Sentencia SQL para crear la tabla en caso de que no exista
    public static final String CREATE_TABLE_ANIMAL = """
                    CREATE TABLE if not exists animal(
                        id INT UNSIGNED AUTO_INCREMENT,
                        dni_cliente VARCHAR(9),
                        nombre VARCHAR(64),
                        especie VARCHAR(32),
                        raza VARCHAR(32),
                        edad INT,
                        CONSTRAINT fk_dniCliente FOREIGN KEY (dni_cliente) REFERENCES cliente(dni)
                            ON UPDATE CASCADE
                            ON DELETE NO ACTION,
                        PRIMARY KEY(id)
                    );
            """;

    // Sentencia para insertar un ANIMAL
    private static final String INSERT_ANIMAL = "INSERT INTO animal (dni_cliente, nombre, especie, raza, edad) VALUES(?, ?, ?, ?, ?)";

    // Sentencia para seleccionar todos los ANIMALES
    private static final String SELECT_ALL_ANIMAL = "Select * from Animal";

    // Sentencia para buscar un ANIMAL por su ID
    private static final String SELECT_BY_DNI_ANIMAL = "Select * from Animal where id=?";

    // Sentencia para actualizar un ANIMAL
    private static final String UPDATE_ANIMAL = "Update Animal set dni_cliente=?, nombre=?, especie=?, raza=?, edad=? where id=?";

    // Sentencia para borrar un ANIMAL
    private static final String DELETE_ANIMAL = "Delete From Animal where id=?";

    // Sentencia par obtener el total de ANIMALES
    private static final String TOTAL_ANIMAL = "Select Count(id) from Animal";

    /**
     * Constructor privado para evitar instancición interna
     * Obtine conexión con la base de datos
     */
    private AnimalDAO(){
        this.connection=DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la instancia de AnimalDAO
     * @return la única instancia de AnimalDAO
     */
    public static synchronized AnimalDAO getInstance() {
        if (instance==null) instance=new AnimalDAO();
        return instance;
    }

    /**
     * Inserta un animal en la base de datos
     * @param animal Animal que se inserta
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public void insertAnimal(Animal animal) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_ANIMAL)) {
            statement.setString(1, animal.getDni_cliente());
            statement.setString(2, animal.getNombreAnimal());
            statement.setString(3, animal.getEspecie());
            statement.setString(4, animal.getRaza());
            statement.setDate(5, java.sql.Date.valueOf(animal.getEdad()));  // Debe ser un int, no un String
            statement.executeUpdate();
        }
    }


    /**
     * Obtiene los datos de todos los animales
     * @return Lista de objetos Animal
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public List<Animal> getAllAnimal() throws SQLException {
        List<Animal> animales = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ANIMAL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) animales.add(resultSetToAnimal(resultSet));
        }
        return animales;
    }

    /**
     * Método que obtiene un Animal a partir del DNI
     * @param id ID del animal que se quiere buscar
     * @return El objeto Animal al que le corresponde ese ID
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public Animal getAnimalByID(int id) throws SQLException {
        Animal animal = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_ANIMAL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                animal = resultSetToAnimal(resultSet);
            }
        }
        return animal;
    }


    /**
     * Metodo que actualiza los datos de un animal por su ID
     * @param animal Objeto con los datos actualizados
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public void updateAnimal(Animal animal) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ANIMAL)) {
            statement.setString(1, animal.getDni_cliente());
            statement.setString(2, animal.getNombreAnimal());
            statement.setString(3, animal.getEspecie());
            statement.setString(4, animal.getRaza());
            statement.setDate(5, java.sql.Date.valueOf(animal.getEdad()));
            statement.executeUpdate();
        }
    }


    /**
     * Metodo que elimina un animal por el ID
     * @param id ID del animal que se quiere eliminar
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public void deleteAnimal(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ANIMAL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    /**
     * Método que convierte que traduce un ResultSet a un objeto Animal
     * @param resultSet Resultado de la consulta a traducir
     * @return Objeto Animal con los datos traducidos
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    private Animal resultSetToAnimal(ResultSet resultSet) throws SQLException {
        return new Animal(
                resultSet.getString("dni_cliente"),
                resultSet.getString("nombre"),
                resultSet.getString("especie"),
                resultSet.getString("raza"),
                resultSet.getDate("edad")
        );
    }

    /**
     * Método que devuelve el número del total de animales
     * @return El número total de animales
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public int totalAnimales() throws SQLException {
        int total=0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_ANIMAL)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) total = resultSet.getInt(1);
        }
        return total;
    }
}

package DB;

import Principal.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase ClienteDAO - Maneja las operaciones de base de datos para la tabla Cliente.
 * Implementa métodos CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar los clientes.
 * Implementa el patrón Singleton para gestionar la conexión a la base de datos.
 *
 * @version 01-2025
 * @author Raúl Quílez Ruiz
 */

public class ClienteDAO {

    // Creamos la instancia de ClienteDAO
    private static ClienteDAO instance;
    // Creamos la conexión con la base de datos
    private Connection connection;


    /**
     *  Sentencias básicas para la tabla Cliente
     */

    // Sentencia SQL para crear la tabla en caso de que no exista
    public static final String CREATE_TABLE_CLIENTE = """
                    CREATE TABLE IF NOT EXISTS Cliente(
                        dni VARCHAR(9) PRIMARY KEY,
                        nombre VARCHAR(64),
                        telefono INT
                    );
            
            """;

    // Sentencia para insertar un CLIENTE
    private static final String INSERT_CLIENTE = "INSERT INTO Cliente (dni, nombre, telefono) VALUES (?, ?, ?)";

    // Sentencia para seleccionar todos los CLIENTES
    private static final String SELECT_ALL_CLIENTE = "Select * from Cliente";

    // Sentencia para buscar un CLIENTE por su DNI
    private static final String SELECT_BY_DNI_CLIENTE = "Select * from Cliente where dni=?";

    // Sentencia para actualizar un CLIENTE
    private static final String UPDATE_CLIENTE = "Update Cliente set nombre=?, telefono=? where dni=?";

    // Sentencia para borrar un CLIENTE
    private static final String DELETE_CLIENTE = "Delete From Cliente where dni=?";

    // Sentencia par obtener el total de CLIENTES
    private static final String TOTAL_CLIENTE = "Select Count(dni) from cliente";

    /**
     * Constructor privado para evitar instancición interna
     * Obtine conexión con la base de datos
     */
    private ClienteDAO(){
        this.connection=DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la instancia de ClienteDAO
     * @return la única instancia de ClienteDAO
     */
    public static synchronized ClienteDAO getInstance() {
        if (instance==null) instance=new ClienteDAO();
        return instance;
    }

    /**
     * Inserta un cliente en la base de datos
     * @param cliente Cliente que se inserta
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public void insertCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_CLIENTE)) {
            statement.setString(1, cliente.getDniCliente());
            statement.setString(2, cliente.getNombreCliente());
            statement.setInt(3, cliente.getTelefono());
            statement.executeUpdate();
        }
    }


    /**
     * Obtiene los datos de todos los clientes
     * @return Lista de objetos Cliente
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CLIENTE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) clientes.add(resultSetToCliente(resultSet));
        }
        return clientes;
    }

    /**
     * Método que obtiene un CLiente a partir del DNI
     * @param dni DNI del cliente que se quiere buscar
     * @return El objeto Cliente al que le corresponde ese DNI
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public Cliente getClienteByDNI(String dni) throws SQLException {
        Cliente c = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_CLIENTE)) {
            statement.setString(1,dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) c = resultSetToCliente(resultSet);
        }
        return c;
    }

    /**
     *  Metodo que actualiza los datos de un cliente por su DNI
     * @param cliente Objeto con los datos actualizados
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public void updateCliente(Cliente cliente) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENTE)) {
            statement.setString(1, cliente.getNombreCliente());
            statement.setInt(2, cliente.getTelefono());
            statement.setString(3, cliente.getDniCliente());
            statement.executeUpdate();
        }
    }



    /**
     * Metodo que elimina un cliente por el DNI
     * @param dni DNI del cliente que se quiere eliminar
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public void deleteCliente(String dni) throws SQLException {
        try (PreparedStatement statement=connection.prepareStatement(DELETE_CLIENTE)) {
            statement.setString(1,dni);
            statement.executeUpdate();
        }
    }

    /**
     * Método que convierte que traduce un ResultSet a un objeto Cliente
     * @param resultSet Resultado de la consulta a traducir
     * @return Objeto Cliente con los datos traducidos
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    private Cliente resultSetToCliente(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getString("dni"),
                resultSet.getString("nombre"),
                resultSet.getInt("telefono")
        );
    }

    /**
     * Método que devuelve el número del total de clientes
     * @return El número total de clientes
     * @throws SQLException Por si ocurre un error con la base de datos
     */
    public int totalClientes() throws SQLException {
        int total=0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_CLIENTE)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) total = resultSet.getInt(1);
        }
        return total;
    }
}

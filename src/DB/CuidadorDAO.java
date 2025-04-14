package DB;

import Principal.Cuidador;
import Principal.Empleado;
import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CuidadorDAO - Maneja las operaciones de base de datos para la tabla Cuidador.
 * Implementa métodos CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar los cuidadores.
 * Implementa el patrón Singleton para asegurar una única instancia.
 * Extiende de EmpleadoDAO {@link EmpleadoDAO}
 *
 * @version 01-2025
 * @author Juan Carlos Garcia
 */
public class CuidadorDAO extends EmpleadoDAO{
    // Instancia única de PersonaDAO
    private static CuidadorDAO instance;

    // Conexión a la base de datos
    private Connection connection;

    //Sentencia SQL para crear la si no existe

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO Cuidador (dni, nombre, telefono, NumeroCuenta, Sueldo) VALUES (?, ?, ?, ?,?)";
    private static final String INSERT_QUERY_EMPLEADO = "INSERT INTO Empleado(dni, nombre, telefono, NumeroCuenta, Sueldo) VALUES (?, ?, ?, ?,?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Cuidador";
    private static final String SELECT_BY_DNI_QUERY = "SELECT * FROM Cuidador WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE Cuidador SET dni = ?, nombre = ?, telefono = ? , NumeroCuenta = ?  WHERE dni = ?";
    private static final String UPDATE_QUERY_EMPLEADO = "UPDATE Cuidador SET dni = ?, nombre = ?, telefono = ? , NumeroCuenta = ?  WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM Cuidador WHERE dni = ?";
    private static final String DELETE_QUERY_EMPLEADO = "DELETE FROM Cuidador WHERE dni = ?";
    private static final String TOTAL_PERSONAS_QUERY = "SELECT COUNT(*) FROM Cuidador";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private CuidadorDAO() {
        super();
        this.connection = DBConnection.getConnection();

    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     *
     * @return instancia única de PersonaDAO.
     */
    public static synchronized CuidadorDAO getInstance() {
        if (instance == null) {
            instance = new CuidadorDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva empleado en la base de datos.
     *
     * @param empleado Objeto Persona a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    @Override
    public void insertEmpleado(Empleado empleado) throws SQLException {
        boolean autocommit = true;
        autocommit = connection.getAutoCommit();
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, empleado.getDniEmpleado());
            statement.setString(2, empleado.getNombreEmpleado());
            statement.setInt(3, empleado.getTelefono());
            statement.setString(4, empleado.getNumCuenta());
            statement.setDouble(5, empleado.getSueldo());
            statement.executeUpdate();
            PreparedStatement statement2 = connection.prepareStatement(INSERT_QUERY_EMPLEADO);
            statement2.setString(1, empleado.getDniEmpleado());
            statement2.setString(2, empleado.getNombreEmpleado());
            statement2.setInt(3, empleado.getTelefono());
            statement2.setString(4, empleado.getNumCuenta());
            statement2.setDouble(5, empleado.getSueldo());
            statement2.executeUpdate();

            connection.commit();
            connection.setAutoCommit(autocommit);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }

    }

    /**
     * Obtiene todas las personas almacenadas en la base de datos.
     *
     * @return Lista de objetos Persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */

    public List<Cuidador> getAllPersonas() throws SQLException {
        List<Cuidador> personas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                personas.add(resultSetToPersona(resultSet));
            }
        }
        return personas;
    }

    /**
     * Obtiene una persona a partir de su DNI.
     *
     * @param dni Identificador único de la persona.
     * @return Objeto Persona si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Cuidador getPersonaByDni(String dni) throws SQLException {
        Cuidador persona = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_QUERY)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                persona = resultSetToPersona(resultSet);
            }
        }
        return persona;
    }

    /**
     * Actualiza los datos de una empleado en la base de datos.
     *
     * @param empleado Objeto Persona con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    @Override
    public void updateVeterinario(Empleado empleado) throws SQLException {
        boolean autocommit = true;

        autocommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, empleado.getDniEmpleado());
            statement.setString(2, empleado.getNombreEmpleado());
            statement.setInt(3, empleado.getTelefono());
            statement.setString(4, empleado.getNumCuenta());
            statement.setDouble(5, empleado.getSueldo());

            PreparedStatement statement2 = connection.prepareStatement(UPDATE_QUERY_EMPLEADO);
            statement2.setString(1, empleado.getDniEmpleado());
            statement2.setString(2, empleado.getNombreEmpleado());
            statement2.setInt(3, empleado.getTelefono());
            statement2.setString(4, empleado.getNumCuenta());
            statement2.setDouble(5, empleado.getSueldo());

            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(autocommit);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }

    }

    /**
     * Elimina una persona de la base de datos por su DNI.
     *
     * @param dni Identificador único de la persona a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    @Override
    public void deleteVeterinarioByDni(String dni) throws SQLException {
        boolean autocommit = true;
        autocommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            PreparedStatement statement2 = connection.prepareStatement(DELETE_QUERY_EMPLEADO);
            statement2.setString(1, dni);

            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(autocommit);
        } catch (SQLException ex) {
            connection.rollback();
            throw ex;
        }

    }

    /**
     * Convierte un ResultSet en un objeto Persona.
     *
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Persona con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Cuidador resultSetToPersona(ResultSet resultSet) throws SQLException {
        return new Cuidador(
                resultSet.getString("DNI"),
                resultSet.getString("Nombre"),
                resultSet.getInt("Telefono"),
                resultSet.getString("Cuenta"),
                resultSet.getInt("Sueldo"));
    }

    /**
     * Obtiene el total de personas almacenadas en la base de datos.
     *
     * @return Número total de personas.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalPersonas() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PERSONAS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}



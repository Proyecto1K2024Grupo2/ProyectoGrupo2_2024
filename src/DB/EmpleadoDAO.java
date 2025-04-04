package DB;

import Principal.Cuidador;
import Principal.Empleado;
import Principal.Recepcionista;

import java.sql.SQLException;

/**
 * Clase EmpleadoDAO - Almacena los métodos abstractos que se usan en sus subclases.
 * {@link RecepcionistaDAO},{@link CuidadorDAO}, {@link VeterinarioDAO},{@link CirujanoDAO}
 *
 * @version 01-2025
 * @author Juan Carlos Garcia
 */
public abstract class EmpleadoDAO {
    public abstract void insertEmpleado(Empleado empleado) throws SQLException;

    public abstract void updateEmpleado(Empleado empleado) throws SQLException;

    public abstract void deleteEmpleadoByDni(String dni) throws SQLException;
}

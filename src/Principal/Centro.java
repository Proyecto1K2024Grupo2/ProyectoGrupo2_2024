package Principal;

import DB.CentroDAO;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Representa un centro (local físico).
 * A un centro estan asociaciadas las salas de este, sus empleados y las citas.
 */
public class Centro {

    private int cod;
    private String nombreCentro;
    private String direccion;
    private String cp;

    //Constructor por defecto

    /**
     * Constructor de la clase Centro el cual te permite crear un centro.
     * @param nombre nombre del centro.
     * @param direccion Dirección del centro.
     * @param cp Código Postal de la zona en la cual se encuentra el centro.
     */
    public Centro(String nombre, String direccion, String cp) {
    }


    //Getters y Setters
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }


    /**
     * Convierte los datos del centro a XML.
     * @return Devuelve un String con los datos de Centro a XML.
     */
    public String centroToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <codigo>").append(cod).append("</codigo>")
                .append("      <nombre>").append(nombreCentro).append("</nombre")
                .append("      <direccion>").append(direccion).append("</direccion>")
                .append("      <cp>").append(cp).append("</cp>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del centro a JSON.
     * @return Devuelve un String con los datos de Centro a JSON.
     */
    public String centroToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"codigo\": \"").append(cod).append("\", ")
                .append("\"nombre\": \"").append(nombreCentro).append("\", ")
                .append("\"direccion\": \"").append(direccion).append("\", ")
                .append("\"cp\": \"").append(cp).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

    /*public static void main(String[] args) throws SQLException {
        CentroDAO centroDAO = new CentroDAO();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("""
                    ===== MENÚ CENTROS =====
                    1. Mostrar datos de todos los centros
                    2. Mostrar datos de un centro por ID
                    3. Insertar centro
                    4. Actualizar datos de centro
                    5. Eliminar un centro
                    6. Numero total de centros
                    7. SALIR
                    """);
            opc= sc.nextInt();

            switch (opc) {
            case 1 -> System.out.println(centroDAO.getAllCentros());
            case 2 -> System.out.println(centroDAO.getCentroByCod(pedirCentro(sc)));
            case 3 ->
            }
        } while (opc!=7);
    }

    public static int pedirCentro(Scanner sc) {
        System.out.println("Introduce el ID del centro: ");
        try {
            return sc.nextInt();
        } catch (Exception e) {
            sc.nextLine(); // Limpiar buffer
            System.out.println("ERROR, formato de ID no válido.");
            throw new RuntimeException(e);
        }
    }

    public static Centro crearCentro(Scanner sc) {
        System.out.println("Introduce el nombre del centro");
        String nomCen=sc.next();
        if (!nomCen.matches(".{1,64}")) throw new IllegalArgumentException("Nombre del centro no válido".");

        System.out.println("Introduce la dirección del centro");
        String direc=sc.next();
        if (!direc.matches(".{1,64}")) throw new IllegalArgumentException("Dirección del centro no válida".");

        System.out.println("Introduce el código postal del centro");
        String cp=sc.next();
        if (!nomCen.matches("\\d{5}")) throw new IllegalArgumentException("Código postal del centro no válido"."));

        return new Centro(nomCen, direc, cp);
        }*/

}
package Principal;

import DB.ClienteDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Cliente {
    private String dniCliente;
    private String nombreCliente;
    private int telefono;

    // Metodo que se utilizó para hacer pruebas de la conexión con la BD y se utiliza en el main de abajo.
    private static ClienteDAO clienteDAO;

    /**
     * Constructor sin parámetros de la clase Cliente
     */
    public Cliente() {
    }

    /**
     * Constructor para crear un Cliente
     * @param dni DNI del cliente.
     * @param nombre Nombre del cliente.
     * @param telef Número de teléfono del cliente.
     */
    public Cliente(String dni, String nombre, int telef) {
        dniCliente = dni;
        nombreCliente = nombre;
        telefono = telef;
    }

    //Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    /**
     * Convierte los datos del Cliente a XML.
     * @return Devuelve un String con los datos de Cliente a XML.
     */
    public String clienteToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <dni>").append(dniCliente).append("</dni>")
                .append("      <nombre>").append(nombreCliente).append("</nombre>")
                .append("      <telefono>").append(telefono).append("</telefono>");
        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del Cliente a JSON.
     * @return Devuelve un String con los datos de Cliente a JSON.
     */
    public String clienteToJSON() {
        return "{"
                + "\"dni\":\"" + dniCliente + "\","
                + "\"nombre\":\"" + nombreCliente + "\","
                + "\"telefono\":\"" + telefono + "\""
                + "}";
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opc=0;
        System.out.println("""
                Menú de Clientes
                ------------------------------------------
                1. Insertar cliente
                2. Mostrar datos de todos los clientes
                3. Mostrar datos de un cliente por el DNI
                4. Actualizar datos del cliente
                5. Eliminar un cliente
                6. Número total de clientes
                7. Salir
                """);
        opc = sc.nextInt();
        while (!sc.hasNextInt()) {
            System.out.println("Asegurate que es un número");
            opc = sc.nextInt();
        }

        switch (opc) {
            case 1 -> clienteDAO.insertCliente(crearCliente());
            case 2 -> clienteDAO.getAllClientes().forEach(System.out::println);
            case 3 -> {
                System.out.println("Introduce el DNI de la persona que quieres actualizar");
                String dni = sc.next();
                while (!esCorrectoNIF(dni)) {
                    System.out.println("Error, DNI no válido, vuelve a introducirlo");
                    dni=sc.next();
                }
                System.out.println(clienteDAO.getClienteByDNI(dni));
            }
            case 4 -> clienteDAO.updateCliente(crearCliente());
            case 5 -> {
                System.out.println("Introduce el DNI de la persona que quieres borrar");
                String dni = sc.next();
                while (!esCorrectoNIF(dni)) {
                    System.out.println("Error, DNI no válido, vuelve a introducirlo");
                    dni=sc.next();
                }
                clienteDAO.deleteCliente(dni);
            }
            case 6 -> System.out.println(clienteDAO.totalClientes());
            case 7 -> System.out.println("Saliendo del menú de clientes...");
            default -> System.out.println("Selecciona una opción correcta");
        }
    }

    private static Cliente crearCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el DNI");
        String dni = sc.next();
        while (!esCorrectoNIF(dni)) {
            System.out.println("Error, DNI no válido, vuelve a introducirlo");
            dni = sc.next();
        }

        System.out.println("Escribe el nombre del cliente");
        String nom = sc.next();

        System.out.println("Escribe el teléfono");
        int tel = 0;
        while (!sc.hasNextInt() && tel==0) {
            System.out.println("Asegurate que es un número");
            tel = sc.nextInt();
        }

        return new Cliente(dni, nom, tel);
    }

    private static boolean esCorrectoNIF(String NIF){
        boolean nif=true;

        if (NIF.length()!=9)
            nif=false;

        if (nif) {
            for (int c = 0; c < 8; c++) {
                if (!Character.isDigit(NIF.charAt(c))) {
                    nif = false;
                }
            }
        }
        if (nif) {
            char letra = NIF.charAt(8);
            Character.toUpperCase(letra);
            if (!Character.isLetter(letra))
                nif = false;


            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            String numeros = NIF.substring(0, 8);
            int num = Integer.parseInt(numeros);
            char letraEsp = letras.charAt(num % 23);
            Character.toUpperCase(letraEsp);

            if (letraEsp != letra)
                nif = false;
        }
        return nif;
    }
}
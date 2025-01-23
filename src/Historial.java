
public class Historial {

    private int id_cita;
    private int id_animal;
    private int id_tratamiento;

    /**
     * @param idCita
     * @param idAnimal
     * @param idTratamiento
     */
    public Historial(int idCita, int idAnimal, int idTratamiento) {
        // TODO implement here
    }

    /**
     *
     */
    public void añadirHistorial() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarHistorial() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarHistorial() {
        // TODO implement here
    }

    public String historialToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <id_cita>").append(id_cita).append("</id_cita>")
                .append("      <id_animal>").append(id_animal).append("</id_animal")
                .append("      <id_tratamiento>").append(id_tratamiento).append("</id_tratamiento>");
        return xmlBuilder.toString();
    }
}
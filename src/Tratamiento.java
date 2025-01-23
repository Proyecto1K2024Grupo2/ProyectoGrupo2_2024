
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.time.LocalTime;

public class Tratamiento {

    private int id;
    private String tratamiento;
    private String medicamento;
    private String posologia;
    private LocalDate fechaCuidador;
    private LocalTime horaCuidador;
    private LocalDate fechaVeterinario;
    private LocalTime horaVeterinario;
    private LocalDate fechaCirujano;
    private LocalTime horaCirujano;
    private String dni_veterinario;
    private String dni_cirujano;
    private String dni_cuidador;

    //Constructor por defecto
    public Tratamiento() {
    }

    public Tratamiento(int id, String tratamiento, String medicamento, String posologia) {
        this.id = id;
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
        this.posologia = posologia;
    }

    /**
     *
     */
    public void añadirTratamiento() {
        // TODO implement here
    }

    /**
     *
     */
    public void borrarTratamiento() {
        // TODO implement here
    }

    /**
     *
     */
    public void actualizarTratamiento() {
        // TODO implement here
    }

    public String empleadoToXML(){
        StringBuilder xmlBuilder=new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <tratamiento>").append(tratamiento).append("</tratamiento")
                .append("      <numCuenta>").append(medicamento).append("</numCuenta>")
                .append("      <posologia>").append(posologia).append("</posologia>")
                .append("      <fechaCuidador>").append(fechaCuidador).append("</fechaCuidador>")
                .append("      <horaCuidador>").append(horaCuidador).append("</horaCuidador>")
                .append("      <fechaVeterinario>").append(fechaVeterinario).append("</fechaVeterinario")
                .append("      <horaVeterinario>").append(horaVeterinario).append("</horaVeterinario>")
                .append("      <fechaCirujano>").append(fechaCirujano).append("</fechaCirujano>")
                .append("      <horaCirujano>").append(horaCirujano).append("</horaCirujano>")
                .append("      <dni_cuidador>").append(dni_cuidador).append("</dni_cuidador>")
                .append("      <dni_veterinario>").append(dni_veterinario).append("</dni_veterinario>")
                .append("      <dni_cirujano>").append(dni_cirujano).append("</dni_cirujano>");
        return xmlBuilder.toString();
    }
}
package Principal;

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


    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public LocalDate getFechaCuidador() {
        return fechaCuidador;
    }

    public void setFechaCuidador(LocalDate fechaCuidador) {
        this.fechaCuidador = fechaCuidador;
    }

    public LocalTime getHoraCuidador() {
        return horaCuidador;
    }

    public void setHoraCuidador(LocalTime horaCuidador) {
        this.horaCuidador = horaCuidador;
    }

    public LocalDate getFechaVeterinario() {
        return fechaVeterinario;
    }

    public void setFechaVeterinario(LocalDate fechaVeterinario) {
        this.fechaVeterinario = fechaVeterinario;
    }

    public LocalTime getHoraVeterinario() {
        return horaVeterinario;
    }

    public void setHoraVeterinario(LocalTime horaVeterinario) {
        this.horaVeterinario = horaVeterinario;
    }

    public LocalDate getFechaCirujano() {
        return fechaCirujano;
    }

    public void setFechaCirujano(LocalDate fechaCirujano) {
        this.fechaCirujano = fechaCirujano;
    }

    public LocalTime getHoraCirujano() {
        return horaCirujano;
    }

    public void setHoraCirujano(LocalTime horaCirujano) {
        this.horaCirujano = horaCirujano;
    }

    public String getDni_veterinario() {
        return dni_veterinario;
    }

    public void setDni_veterinario(String dni_veterinario) {
        this.dni_veterinario = dni_veterinario;
    }

    public String getDni_cirujano() {
        return dni_cirujano;
    }

    public void setDni_cirujano(String dni_cirujano) {
        this.dni_cirujano = dni_cirujano;
    }

    public String getDni_cuidador() {
        return dni_cuidador;
    }

    public void setDni_cuidador(String dni_cuidador) {
        this.dni_cuidador = dni_cuidador;
    }


    public String tratamientoToXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("      <id>").append(id).append("</id>")
                .append("      <tratamiento>").append(tratamiento).append("</tratamiento>")
                .append("      <numCuenta>").append(medicamento).append("</numCuenta>")
                .append("      <posologia>").append(posologia).append("</posologia>")
                .append("      <fechaCuidador>").append(fechaCuidador).append("</fechaCuidador>")
                .append("      <horaCuidador>").append(horaCuidador).append("</horaCuidador>")
                .append("      <fechaVeterinario>").append(fechaVeterinario).append("</fechaVeterinario>")
                .append("      <horaVeterinario>").append(horaVeterinario).append("</horaVeterinario>")
                .append("      <fechaCirujano>").append(fechaCirujano).append("</fechaCirujano>")
                .append("      <horaCirujano>").append(horaCirujano).append("</horaCirujano>")
                .append("      <dni_cuidador>").append(dni_cuidador).append("</dni_cuidador>")
                .append("      <dni_veterinario>").append(dni_veterinario).append("</dni_veterinario>")
                .append("      <dni_cirujano>").append(dni_cirujano).append("</dni_cirujano>");
        return xmlBuilder.toString();
    }

    public String tratamientoToJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"id\": \"").append(id).append("\", ")
                .append("\"tratamiento\": \"").append(tratamiento).append("\", ")
                .append("\"numCuenta\": \"").append(medicamento).append("\", ")
                .append("\"posologia\": \"").append(posologia).append("\", ")
                .append("\"fechaCuidador\": \"").append(fechaCuidador).append("\", ")
                .append("\"horaCuidador\": \"").append(horaCuidador).append("\", ")
                .append("\"fechaVeterinario\": \"").append(fechaVeterinario).append("\", ")
                .append("\"horaVeterinario\": \"").append(horaVeterinario).append("\", ")
                .append("\"fechaCirujano\": \"").append(fechaCirujano).append("\", ")
                .append("\"horaCirujano\": \"").append(horaCirujano).append("\", ")
                .append("\"dni_cuidador\": \"").append(dni_cuidador).append("\", ")
                .append("\"dni_veterinario\": \"").append(dni_veterinario).append("\", ")
                .append("\"dni_cirujano\": \"").append(dni_cirujano).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

}
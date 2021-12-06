package main.models;

import java.io.Serializable;

/**
 * Classe responsável por definir a residência médica(área de atuação de um médico)
 * @author Ariel Carvalho
 */
public class MedicalResidency implements Serializable{
    
    private String description;
    private Doctor doctor;

    public MedicalResidency(String description) {
        this.description = description;
        this.doctor = null;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    //Se o médico tiver 2 residências, não adicionar. Talvez utilize try/catch
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public void disassociateDoctor(){ this.doctor = null; }
}

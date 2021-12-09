package main.models;

import java.io.Serializable;

/**
 * Classe responsável por definir a residência médica(área de atuação de um médico)
 * @author Ariel Carvalho
 */
public class MedicalResidency implements Serializable{

    private String description;

    public MedicalResidency(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MedicalResidency{" +
                "description='" + description + '\'' +
                '}';
    }
}
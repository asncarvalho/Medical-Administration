/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

public class Doctor extends User{

    private String primarySpecialization;

    private String secondarySpecialization;

    private final MedicalResidency[] medicalResidencies;

    public Doctor(String name, String cpf, String password) {
        super(name,cpf,password);
        this.medicalResidencies = new MedicalResidency[2];
    }

    public String getPrimarySpecialization() {
        return primarySpecialization;
    }

    public void setPrimarySpecialization(String primarySpecialization) {
        this.primarySpecialization = primarySpecialization;
    }

    public String getSecondarySpecialization() {

        return secondarySpecialization;
    }

    public void setSecondarySpecialization(String secondarySpecialization) {
        this.secondarySpecialization = secondarySpecialization;
    }

    @Override
    public String toString() {
        return "Doctor {" +
                "\nname = " + super.getName() +
                ", \ncpf = " + super.getCpf() +
                ", \npassword = " + super.getPassword() +
                ", \nprimarySpecialization= " + primarySpecialization +
                ", \nsecondarySpecialization= " + secondarySpecialization +
                "} " ;
    }

    public MedicalResidency[] getMedicalResidencies() {
        return medicalResidencies;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.models;

import java.util.Arrays;

public class Doctor extends User{
    private final MedicalResidency[] medicalResidencies;

    // Por um array de dois lugares para as classes de residência médica.

    public Doctor(String name, String cpf, String password) {
        super(name,cpf,password);
        this.medicalResidencies = new MedicalResidency[2];
    }

    public MedicalResidency[] getMedicalResidencies() {
        return medicalResidencies;
    }


    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getMedicalResidencies());
        return result;
    }

    @Override
    public String toString() {
        return "Doctor {" +
                "\nname = " + super.getName() +
                ", \ncpf = " + super.getCpf() +
                ", \npassword = " + super.getPassword() +
                ", \nmedicalResidencies = " + Arrays.toString(medicalResidencies) +
                "} " ;
    }
}
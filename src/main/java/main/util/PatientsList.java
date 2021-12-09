package main.util;

import main.models.Patient;

import java.util.ArrayList;

/**
 * @author arielcarvalho
 */
public class PatientsList extends LinkedList<Patient>{
    
    public PatientsList(){
        
    }
    
    public Patient searchByCpf(String cpf){
        for(Patient current : this){
            if(current.getCpf().equals(cpf)) return current;
        }
        return null;
    }

    public ArrayList<Patient> toArray(){
        ArrayList<Patient> arrayList = new ArrayList<>();
        for(Patient current : this){
            arrayList.add(current);
        }
        return arrayList;
    }
}

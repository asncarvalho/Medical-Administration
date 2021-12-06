package main.util;

import main.models.Patient;

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
}

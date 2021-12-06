package main.util;

import main.models.Doctor;


/**
 *
 * @author arielcarvalho
 */
public class DoctorsList extends LinkedList<Doctor>{
    
    public DoctorsList(){
        
    }
    
    public Doctor searchByCpf(String cpf){
        for(Doctor current : this){
            if(current.getCpf().equals(cpf)) return current;
        }
        return null;
    }
}

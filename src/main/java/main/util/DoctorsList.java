package main.util;

import main.models.Doctor;
import main.models.Patient;

import java.util.ArrayList;


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

    public ArrayList<Doctor> toArray(){
        ArrayList<Doctor> arrayList = new ArrayList<>();
        for(Doctor current : this){
            arrayList.add(current);
        }
        return arrayList;
    }
}

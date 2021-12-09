package main.util;

import main.models.MedicalResidency;

import java.util.ArrayList;

public class ResidenciesList extends LinkedList<MedicalResidency> {

    public ResidenciesList() {
    }

    public MedicalResidency searchByName(String name){
        for(MedicalResidency current : this){
            if(current.getDescription().equals(name)) return current;
        }
        return null;
    }

    public ArrayList<MedicalResidency> toArray(){
        ArrayList<MedicalResidency> arrayList = new ArrayList<>();
        for(MedicalResidency current : this){
            arrayList.add(current);
        }
        return arrayList;
    }
}

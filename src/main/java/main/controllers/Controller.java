package main.controllers;

import main.models.MedicalResidency;
import main.util.*;


/**
 * @author arielcarvalho
 */
public class Controller implements FileStream<Controller> {

    private static Controller instance;
    private DoctorsList doctorsList;
    private PatientsList patientList;
    private UsersList userList;
    private ResidenciesList specializations;

    private Controller() {
        this.doctorsList = new DoctorsList();
        this.patientList = new PatientsList();
        this.userList = new UsersList();
        this.specializations = new ResidenciesList();
    }
    
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public DoctorsList getDoctorsList() { return this.doctorsList; }

    public PatientsList getPatientList() { return patientList; }

    public UsersList getUserList() { return userList; }

    public ResidenciesList getSpecializations() { return specializations; }

    @Override
    public void set(Controller data) {
        this.doctorsList = data.doctorsList;
        this.patientList = data.patientList;
        this.userList = data.userList;
        this.specializations = data.specializations;
    }

}

package main.controllers;

import main.util.DoctorsList;
import main.util.FileStream;
import main.util.PatientsList;
import main.util.UsersList;


/**
 * @author arielcarvalho
 */
public class Controller implements FileStream<Controller> {

    private static Controller instance;
    private DoctorsList doctorsList;
    private PatientsList patientList;
    private UsersList userList;

    private Controller() {
        this.doctorsList = new DoctorsList();
        this.patientList = new PatientsList();
        this.userList = new UsersList();
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

    @Override
    public void set(Controller data) {
        this.doctorsList = data.doctorsList;
        this.patientList = data.patientList;
        this.userList = data.userList;
    }
    
}

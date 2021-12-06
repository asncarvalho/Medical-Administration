package main.controllers;

import main.models.Doctor;
import main.models.Patient;
import main.models.User;

import java.util.Optional;

/**
 * @author arielcarvalho
 */
public class AuthController {
    private static AuthController instance;

    public static AuthController getInstance() {
        if (instance == null){ instance = new AuthController(); }
        return instance;
    }

    public Optional<?> logIn(String cpf, String password){
        Optional<Doctor> logDoctor = Optional.ofNullable(Controller.getInstance().getDoctorsList().searchByCpf(cpf));
        Optional<Patient> logPatient = Optional.ofNullable(Controller.getInstance().getPatientList().searchByCpf(cpf));
        Optional<User> logUser = Optional.ofNullable(Controller.getInstance().getUserList().searchByCpf(cpf));

        if(logDoctor.isPresent()){
            if(logDoctor.get().getPassword().equals(password)) { return logDoctor; }
            else{ return Optional.empty(); }
        }else if(logPatient.isPresent()){
            if(logPatient.get().getPassword().equals(password)) { return logPatient; }
            else{ return Optional.empty(); }
        }else if(logUser.isPresent()){
            if(logUser.get().getPassword().equals(password)) { return logUser; }
            else{ return Optional.empty(); }
        }else{
           return Optional.empty();
        }
    }
    
    
    
}

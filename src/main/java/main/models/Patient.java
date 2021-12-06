package main.models;

import main.util.IList;
import main.util.LinkedList;

public class Patient extends User{
    private final IList<Queries> queriesList;

    public Patient(String name, String cpf, String password) {
        super(name, cpf, password);
        this.queriesList = new LinkedList<>();
    }

    public IList<Queries> getQueriesList() { return queriesList; }

    @Override
    public String toString() {
        return "Patient {" +
                "\nname = " + super.getName() +
                ",\ncpf = " + super.getCpf() +
                ",\npassword = " + super.getPassword() +
                ",\nqueriesList=" + queriesList +
                "} " ;
    }
}

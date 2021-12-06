package main.models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
    private String name;
    private String cpf;
    private String password;

    public User(String name, String cpf, String password) {
        this.name = name;
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() { return cpf; }

    public String getName() { return name; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setName(String name) { this.name = name; }

    // Maybe can be until.
    public String getPassword() { return password; }

//    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User {" +
                "\nname=" + name +
                ", \ncpf=" + cpf +
                ", \npassword=" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getName().equals(user.getName()) && getCpf().equals(user.getCpf()) && getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCpf(), getPassword());
    }
}

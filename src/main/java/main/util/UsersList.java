package main.util;

import main.models.User;

/**
 * @author arielcarvalho
 */
public class UsersList extends LinkedList<User>{

    public UsersList() {
    }
    
    public User searchByCpf(String cpf){
        for(User current : this){
            if(current.getCpf().equals(cpf)) return current;
        }
        return null;
    }
}

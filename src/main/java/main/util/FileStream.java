/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface FileStream<T> extends Serializable{
    
    void set(final T data);

    @SuppressWarnings("unchecked")
    default void loadFile(final String fileName) throws IOException, ClassNotFoundException, ClassCastException {
        try(final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            this.set((T) objectInputStream.readObject());
            objectInputStream.close();
        }
    }


    default void saveFile(final String fileName) throws IOException {
        try(final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        }
    }
}

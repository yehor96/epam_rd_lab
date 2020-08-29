package com.epam.test.ht8.task3;

import java.io.*;

public class Serialization<T> {
    public void serializeObject(T object, String file) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Serialization is completed.");
    }

    public T deserializeObject(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        T object = (T) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("Deserialization is completed.");
        return object;
    }
}

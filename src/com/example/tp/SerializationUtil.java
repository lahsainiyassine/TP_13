package com.example.tp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class SerializationUtil {

   
    public static void serializeEmployees(String path, List<Employee> data) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(data);
        }
    }

   
    @SuppressWarnings("unchecked")
    public static List<Employee> deserializeEmployees(String path)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Employee>) ois.readObject();
        }
    }
}
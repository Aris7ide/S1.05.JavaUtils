package service;

import java.io.*;

public class Serial {

    public static void newSerial(String path, Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Object readSerial(String path) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            PersonClass p = (PersonClass) ois.readObject();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

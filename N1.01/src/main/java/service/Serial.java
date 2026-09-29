package service;

import java.io.*;

public class Serial {

    public static void newSerial(String path, Object obj) {
        File file = new File(path);

        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
            System.out.println("The object " + obj.toString() +  " have been serialized");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Object readSerial(String path) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            PersonClass p = (PersonClass) ois.readObject();
            System.out.println("The object " + p.toString() +  " has been deserialized");
            return p;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

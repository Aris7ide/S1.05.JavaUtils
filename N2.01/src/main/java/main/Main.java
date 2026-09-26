package main;

import service.ConfigLoader;
import service.DirectoryLister;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    static void main(String[] args) {

        final String filePath = ConfigLoader.getProperty("app.data.file", "");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            DirectoryLister.alphabeticalDirectoryLister(".", 0,writer);
            System.out.println("El file ha sido guardado correctamente");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}

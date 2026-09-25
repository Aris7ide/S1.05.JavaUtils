package main;

import service.DirectoryLister;
import service.NewFileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter(new FileWriter("N1.01/directory_structure.txt"))) {
            DirectoryLister.alphabeticalDirectoryLister(".", 0,writer);
            System.out.println("El file ha sido guardado correctamente");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        NewFileReader.readFile("N1.01/src/testRead.txt");
    }
}

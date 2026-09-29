package main;

import service.DirectoryLister;
import service.NewFileReader;
import service.PersonClass;
import service.Serial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    static void main(String[] args) {

        DirectoryLister.alphabeticalDirectoryLister(".", 0);

        System.out.println();

        NewFileReader.readFile("src/testRead.txt");

        System.out.println();

        Serial.newSerial("src/files/test.ser", new PersonClass("Maria","Rossi",29));

        Serial.readSerial("src/files/test.ser");
    }
}

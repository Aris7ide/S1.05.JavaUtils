package service;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryLister {

    public static void alphabeticalDirectoryLister(String directoryPath) {

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.err.println("La carpeta no existe");
            return;
        }

        if (!directory.isDirectory()) {
            System.err.println("No es una carpeta");
            return;
        }

        File[] content = directory.listFiles();

        if (content==null || content.length == 0) {
            System.err.println("La carpeta està vacía");
            return;
        }

        Arrays.sort(content, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

        System.out.println("El contenido de " + directory.getAbsolutePath() + " es:");
        for (File f : content) {
            String tipo = f.isDirectory() ? "[DIR]" : "[FILE]";
            System.out.println(tipo + " " + f.getName());
        }

    }
}

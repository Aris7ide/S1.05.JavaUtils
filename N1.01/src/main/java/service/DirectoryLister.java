package service;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryLister {

    public static void alphabeticalDirectoryLister(String directoryPath, int nivel) {

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
            if (nivel == 0) {
                System.err.println("La carpeta està vacía");
            }
            return;
        }

        Arrays.sort(content, Comparator.comparing(File::getName, String.CASE_INSENSITIVE_ORDER));

        if (nivel == 0) {
            System.out.println("El contenido de " + directory.getAbsolutePath() + " es:");
        }

        for (File f : content) {
            String tipo = f.isDirectory() ? "[DIR]" : "[FILE]";
            String date = dateFormat(f.lastModified());
            System.out.println(("\t").repeat(nivel) + tipo + " " + f.getName() + " Last edit: " + date);
            if (f.isDirectory()) {
                alphabeticalDirectoryLister(f.getAbsolutePath(), nivel + 1);
            }
        }

    }

    public static String dateFormat(Long date) {
        Instant instant = Instant.ofEpochMilli(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }
}

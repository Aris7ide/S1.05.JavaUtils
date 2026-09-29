package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryListerTest {

    @TempDir
    Path tempFolder; // Crea un directorio temporal aislado que se borra solo tras el test

    @Test
    void testAlphabeticalDirectoryLister() throws IOException {
        // 1. Arrange: Crear estructura de carpetas y archivos
        Path subFolder = Files.createDirectory(tempFolder.resolve("SubCarpeta"));
        Files.createFile(tempFolder.resolve("archivoB.txt"));
        Files.createFile(tempFolder.resolve("archivoA.txt"));
        Files.createFile(subFolder.resolve("subArchivo.txt"));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        // 2. Act: Llamada exacta a tu método original
        DirectoryLister.alphabeticalDirectoryLister(tempFolder.toString(), 0, printWriter);
        printWriter.flush(); // Asegurar que todo el contenido pasa a la cadena final

        String output = stringWriter.toString();

        // 3. Assert: Verificar que la salida incluye carpetas, archivos y tabulaciones
        assertTrue(output.contains("[FILE] archivoA.txt"));
        assertTrue(output.contains("[FILE] archivoB.txt"));
        assertTrue(output.contains("[DIR] SubCarpeta"));

        // Verifica la llamada recursiva (tabulación \t para el archivo dentro de SubCarpeta)
        assertTrue(output.contains("\t[FILE] subArchivo.txt"));

        // Comprobar orden alfabético (archivoA debe aparecer antes que archivoB)
        int indexA = output.indexOf("archivoA.txt");
        int indexB = output.indexOf("archivoB.txt");
        assertTrue(indexA < indexB, "archivoA.txt debe aparecer antes que archivoB.txt");
    }
}

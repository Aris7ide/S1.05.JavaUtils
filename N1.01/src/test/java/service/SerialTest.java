package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SerialTest {

    @TempDir
    Path tempDir;

    @Test
    void testSerializationAndDeserializationSuccess() {
        PersonClass originalPerson = new PersonClass("Maria", "Rossi", 29);
        File file = tempDir.resolve("test_person.ser").toFile();
        String filePath = file.getAbsolutePath();

        Serial.newSerial(filePath, originalPerson);
        Object deserializedObject = Serial.readSerial(filePath);

        assertNotNull(deserializedObject, "The object shouldn't be null");
        assertInstanceOf(PersonClass.class, deserializedObject, "The object needs to be an instanc of PersonClass");

        PersonClass deserializedPerson = (PersonClass) deserializedObject;
        assertEquals(originalPerson.toString(), deserializedPerson.toString(), "The object should match");
    }

    @Test
    void testNewSerialCreatesDirectories() {
        Path subDirPath = tempDir.resolve("nested").resolve("folders");
        File fileInSubDir = subDirPath.resolve("test.ser").toFile();

        PersonClass person = new PersonClass("Joan", "Pérez", 40);

        Serial.newSerial(fileInSubDir.getAbsolutePath(), person);

        // Verifiquem que la carpeta i el fitxer s'hagin creat[cite: 1]
        assertTrue(fileInSubDir.exists(), "The file should be created in the folder");
    }

    @Test
    void testReadSerialNonExistingFile() {
        File nonExistingFile = tempDir.resolve("inexistent.ser").toFile();

        // Intentem llegir un fitxer que no s'ha creat mai[cite: 1, 3]
        Object result = Serial.readSerial(nonExistingFile.getAbsolutePath());

        // Hauria de capturar la IOException internament i retornar null[cite: 3]
        assertNull(result, "It should be null when the file doesn't exist");
    }



}
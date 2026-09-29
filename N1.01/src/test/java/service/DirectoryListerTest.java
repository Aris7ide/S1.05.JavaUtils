package service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryListerTest {

    @TempDir
    Path tempFolder;

    private File outputFile;

    @BeforeEach
    void setUp() {
        outputFile = new File("directory_structure.txt");
        if (outputFile.exists()) {
            outputFile.delete();
        }
    }

    @AfterEach
    void tearDown() {
        if (outputFile.exists()) {
            outputFile.delete();
        }
    }

    @Test
    void testAlphabeticalDirectoryListerCreatesFileWithContent() throws IOException {
        Path subFolder = Files.createDirectory(tempFolder.resolve("SubFolder"));
        Files.createFile(tempFolder.resolve("archive1.txt"));
        Files.createFile(tempFolder.resolve("archive2.txt"));
        Files.createFile(subFolder.resolve("subArchive.txt"));

        DirectoryLister.alphabeticalDirectoryLister(tempFolder.toString(), 0);

        assertTrue(outputFile.exists(), "The archive directory_structure.txt should be created");

        List<String> lines = Files.readAllLines(outputFile.toPath());
        assertFalse(lines.isEmpty(), "The archive should't be ampty");

        assertTrue(lines.stream().anyMatch(line -> line.contains("[F] archive1.txt")));
        assertTrue(lines.stream().anyMatch(line -> line.contains("[F] archive2.txt")));
        assertTrue(lines.stream().anyMatch(line -> line.contains("[D] SubFolder")));
    }

    @Test
    void testAlphabeticalDirectoryListerNonExistingDirectory() {
        String nonExistingPath = tempFolder.resolve("FakeFolder").toString();

        DirectoryLister.alphabeticalDirectoryLister(nonExistingPath, 0);

        assertFalse(outputFile.exists(), "It shouldn't create the folder");
    }

    @Test
    void testAlphabeticalDirectoryListerFileInsteadOfDirectory() throws IOException {
        Path singleFile = Files.createFile(tempFolder.resolve("singleFile.txt"));

        DirectoryLister.alphabeticalDirectoryLister(singleFile.toString(), 0);

        assertFalse(outputFile.exists(), "It shouldn't create the folder");
    }

    @Test
    void testDateFormat() {
        long epochMilli = Instant.parse("2024-01-15T10:00:00Z").toEpochMilli();

        String formattedDate = DirectoryLister.dateFormat(epochMilli);

        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
        String expectedDate = expectedFormatter.format(Instant.ofEpochMilli(epochMilli));

        assertEquals(expectedDate, formattedDate, "El format de la data ha de coincidir amb dd/MM/yyyy");
    }

}
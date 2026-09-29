package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ConfigLoaderTest {
    @TempDir
    Path tempDir;

    private File tempConfigFile;

    @BeforeEach
    void setUp() throws IOException {
        tempConfigFile = tempDir.resolve("test_config.properties").toFile();

        Properties props = new Properties();
        props.setProperty("app.name", "JavaUtilsApp");
        props.setProperty("app.version", "1.0.0");

        try (FileWriter writer = new FileWriter(tempConfigFile)) {
            props.store(writer, "Test Configuration");
        }

        ConfigLoader.loadConfiguration(tempConfigFile.getAbsolutePath());
    }

    @Test
    void testGetPropertyNonExistingKey() {
        String dbPort = ConfigLoader.getProperty("db.port", "8080");
        assertEquals("8080", dbPort, "Debe devolver el valor por defecto cuando la clave no está en el archivo");
    }

    @Test
    void testCreateFileIfNotExist() {
        File newConfigFile = tempDir.resolve("new_dir").resolve("auto_created.properties").toFile();
        assertFalse(newConfigFile.exists(), "El archivo no debe existir antes del test");

        ConfigLoader.loadConfiguration(newConfigFile.getAbsolutePath());

        assertTrue(newConfigFile.exists(), "El archivo .properties debe crearse automáticamente");
    }

    @Test
    void testGetPropertyExistingKey() {
        String appName = ConfigLoader.getProperty("app.name", "DefaultAppName");
        assertEquals("JavaUtilsApp", appName, "Debe devolver el valor configurado en el archivo");
    }

    @Test
    void testGetPropertyWithNullOrEmptyKey() {
        String result = ConfigLoader.getProperty("non.existing.key", "FallbackValue");
        assertEquals("FallbackValue", result, "Debe manejar de forma segura claves inexistentes");
    }

}
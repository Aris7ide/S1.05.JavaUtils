package service;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;

public class ConfigLoader {

    private static String configPath = "N2.01" + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
    private static FileBasedConfigurationBuilder<PropertiesConfiguration> builder;
    private static PropertiesConfiguration config;

    private ConfigLoader() {}

    static {
        loadConfiguration(configPath);
    }

    public static synchronized void loadConfiguration(String path) {
        configPath = path;
        File externalFile = new File(configPath);

        if (!externalFile.exists()) {
            File parentDir = externalFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            try {
                if (externalFile.createNewFile()) {
                    System.out.println("El archivo .properties ha sido creado en: " + externalFile.getPath());
                }
            } catch (IOException e) {
                System.err.println("Error al crear el archivo .properties: " + e.getMessage());
            }
        }

        Parameters params = new Parameters();
        builder = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class)
                .configure(params.properties().setFile(externalFile));

        try {
            config = builder.getConfiguration();
        } catch (ConfigurationException e) {
            System.err.println("Error al cargar la configuración: " + e.getMessage());
            config = null;
        }
    }

    public static String getProperty(String key, String defaultValue) {
        if (config == null || !config.containsKey(key)) {
            return defaultValue;
        }
        return config.getString(key, defaultValue);
    }
}
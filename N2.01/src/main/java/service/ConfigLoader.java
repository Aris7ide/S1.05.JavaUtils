package service;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;

public class ConfigLoader {

    private static final String EXTERNAL_CONFIG_PATH = "N2.01/src/main/resources/config.properties";

    private static FileBasedConfigurationBuilder<PropertiesConfiguration> builder;
    private static PropertiesConfiguration config;

    private void configLoader() {}

    static {
        File externalFile = new File(EXTERNAL_CONFIG_PATH);
        if (!externalFile.exists()) {
            try {
                boolean fileCreated = externalFile.createNewFile();
                if (fileCreated) {
                    System.out.println("El archivo .properties ha sido creado");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        Parameters params = new Parameters();
        builder = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class).configure(params.properties().setFile(externalFile));
        try {
            config = builder.getConfiguration();
        } catch (ConfigurationException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String getProperty(String key, String defaultValue) {
        if (config == null || !config.containsKey(key)) {
            return defaultValue;
        }
        return config.getString(key, defaultValue);
    }

    public static void setProperty(String key, String value) {
        if (config != null && builder != null) {
            try {
                config.setProperty(key, value);
                builder.save();
                System.out.println("Config updated: " + key + " - " + value);
            } catch (ConfigurationException e){
                System.err.println(e.getMessage());
            }
        }
    }
}

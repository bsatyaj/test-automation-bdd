package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getValueBy(String environment, String key) {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/envconfig/" + environment + ".properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

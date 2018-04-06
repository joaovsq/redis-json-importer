package utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public abstract class PropertiesUtil {

    public static String getProperties(String key) {
        try {
            Properties properties = new Properties();

            File configFile = new File("app.properties");
            FileReader fileReader = new FileReader(configFile);

            properties.load(fileReader);
//            properties.load(this.getClass().getResourceAsStream("/app.properties"));

            return properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

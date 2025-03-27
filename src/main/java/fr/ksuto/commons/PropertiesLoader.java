package fr.ksuto.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    
    public static Properties load(String file) {
        
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        return propertiesLoader.getProperties(file);
    }
    
    public static Properties load() {
        
        return load("");
    }
    
    public Properties getProperties(String file) {
        
        String     propFileName = file.equals("") ? "config.properties" : file + ".properties";
        Properties properties   = null;
        
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return properties;
    }
}

package dataProvider;

import enums.DriverType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import static enums.DriverType.getByName;


public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configs/configurations.properties";

    public ConfigFileReader() {
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("configurations.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
       return getConfigurationProperty("driverPath");
    }

    public long getImplicitWait() {
       return Long.parseLong(getConfigurationProperty("implicitWait"));
    }

    public String getWebsiteURL() {
       return getConfigurationProperty("url");
    }

    public DriverType getBrowser() {
            return getByName(getConfigurationProperty("browser"));
    }

    public String getReportConfigPath() {
      return  getConfigurationProperty("reportConfigPath");
    }

    public String getLogConfigPath() {
        return getConfigurationProperty("logConfigPath");
    }

    private String getConfigurationProperty(String configurationProperty){
        String configProperty = properties.getProperty(configurationProperty);
        if (configProperty != null){
            return configProperty;
        }else{
            throw new RuntimeException("Configuration property: " +configProperty +
                    " not specified in the configurations.properties " + propertyFilePath);
        }
    }
}


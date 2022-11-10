package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * This method is used to load the properties from config.properties file
     *
     * @return - it returns Properties prop object
     */
    public Properties init_prop() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getApplicationUrl() {
        String url = init_prop().getProperty("baseurl");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public static String getInputFilePath(String filePathProperty) {
        ConfigReader configReader = new ConfigReader();
        return configReader.init_prop().getProperty(filePathProperty);
    }

    public String getReportConfigPath(){
        ConfigReader configReader = new ConfigReader();
        return configReader.init_prop().getProperty("reportConfigPath");
    }
}

package com.pacifico.framework.config;

import com.pacifico.framework.base.BrowserType;
import com.pacifico.framework.base.DeviceType;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }

    private void ReadProperty() throws IOException {

        Properties p = new Properties();

        // Cargamos el valor del parámetro environment
        String environment = System.getProperty("environment");
        //String environment = "Demo";  //con esto funciona resbookin
        //Load the PropertyAutos file available in same package
        //String propertiesFile = "ConfigIntegration.properties";
         String propertiesFile = "ConfigCertification.properties";
        //String propertiesFile = "ConfigDemo.properties";  //con esto funciona resbookin*/

        //Creamos el nombre del archivo a cargar
        if (environment != null) {
            propertiesFile = "Config" + StringUtils.capitalize(environment) + ".properties";
        }

        p.load(getClass().getClassLoader().getResourceAsStream(propertiesFile));

        Settings.ScreenPath = p.getProperty("ScreenPath");
        Settings.LogPath = p.getProperty("LogPath");
        Settings.VideoPath = p.getProperty("VideoPath");
        Settings.URLbase = p.getProperty("URLbase");
        Settings.URLambiente = p.getProperty("URLambiente");
        Settings.AUTNeoWeb = p.getProperty("AUTNeoWeb");
        Settings.RecordVideo = p.getProperty("RecordVideo");
        Settings.BrowserClose = p.getProperty("BrowserClose");
        Settings.DriversPath = p.getProperty("DriversPath");
        Settings.EmailEnv = p.getProperty("EmailEnv");
        Settings.BrowserLess = p.getProperty("BrowserLess");
        Settings.PCMWidth = p.getProperty("PCMWidth");
        Settings.PCMHeight = p.getProperty("PCMHeight");
        Settings.PCMPixel = p.getProperty("PCMPixel");
        Settings.ResourcePath = p.getProperty("ResourcePath");
        Settings.UrlServices_BASE_Auth = p.getProperty("UrlServices_BASE_Auth");
        Settings.UrlServices_URI_Auth = p.getProperty("UrlServices_URI_Auth");
        Settings.PCMWidth = p.getProperty("PCMobileDeviceWidth");
        Settings.PCMHeight = p.getProperty("PCMobileDeviceHeight");
        Settings.PCMPixel = p.getProperty("PCMobileDevicePixel");
        Settings.BrowserType = BrowserType.valueOf(p.getProperty("BrowserType"));
        Settings.DeviceType = DeviceType.valueOf(p.getProperty("Device"));

    }

}

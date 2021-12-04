package com.automationbytarun.properties;

import com.automationbytarun.ConfigurationException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesLoader {

         public static Properties configProperties;

        public static String runOnBrowser;
        public static Boolean takeScreenshot;
        public static String chromeDriverPath;
        public static String ieDriverPath;
        public static String edgeDriverPath;
        public static String firefoxDriverPath;
        public static Boolean maximizedMode;
        public static Integer explicitWaitTime;
        public static Integer implicitWaitTime;
        public static Integer pageLoadWaitTime;
        public static Boolean headless;
        public static boolean deleteCookies;
        public static boolean remoteRun;
        public static String appUrl;

        public static void initializeProperties() throws Exception {
            if (configProperties == null) {
                configProperties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//resources//configs.properties"));
                configProperties.load(fileInputStream);

            }


            runOnBrowser = configProperties.getProperty("RunOnBrowser");
            takeScreenshot = Boolean.valueOf(configProperties.getProperty("TakeScreenshot"));
            chromeDriverPath = configProperties.getProperty("ChromeDriverPath");
            edgeDriverPath= configProperties.getProperty("EdgeDriverPath");
            ieDriverPath = configProperties.getProperty("IEDriverPath");
            firefoxDriverPath = configProperties.getProperty("FirefoxDriverPath");
            implicitWaitTime = Integer.valueOf(configProperties.getProperty("ImplicitWait"));
            explicitWaitTime = Integer.valueOf(configProperties.getProperty("ExplicitWait"));
            maximizedMode = Boolean.valueOf(configProperties.getProperty("MaximizeMode"));
            pageLoadWaitTime=Integer.valueOf(configProperties.getProperty("PageLoadWait"));
            headless=Boolean.valueOf(configProperties.getProperty("headless"));
            deleteCookies=Boolean.valueOf(configProperties.getProperty("deleteCookies"));
            remoteRun=Boolean.valueOf(configProperties.getProperty("remoteRun"));
            appUrl= configProperties.getProperty("appUrl");




        }




        public static void main (String[]args)throws Exception {
            PropertiesLoader.initializeProperties();
            PropertiesValidator.validateConfiguration();
        }


    }




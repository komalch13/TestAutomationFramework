package com.automationbytarun.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Chrome extends Browser {
    ChromeOptions chromeoptions;


    @Override
    public void setPreferences() {
        chromeoptions = new ChromeOptions();
        //instantiate the class
        if (isHeadless()) {
            chromeoptions.setHeadless(true);

        }
        if (isMaximized()) {
            chromeoptions.addArguments("start-maximized");//from https://chromedriver.chromium.org/capabilities

        }
        Map<String, Object> prefs = new HashMap<String, Object>();// setting different prefrences codes are written in selenum.dev
        prefs.put("credentials_enable_services", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);
        prefs.put("excludeSwitches",
                Collections.singletonList("enable-automation"));
        chromeoptions.setExperimentalOption("prefs", prefs);

        //chromeoptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking")); //from https://chromedriver.chromium.org/capabilities


    }

    @Override
    public WebDriver loadBrowser(String path) {// path to load the properties
        WebDriver driver= null;

        System.setProperty("webdriver.chrome.driver", path);
        if (isRemote()) {
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeoptions);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            driver= new ChromeDriver(chromeoptions);
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if( isDeleteCookies()){
                driver.manage().deleteAllCookies();
            }


        }
        return driver;
    }
}
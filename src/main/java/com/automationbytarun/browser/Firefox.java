package com.automationbytarun.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Firefox extends Browser{

    FirefoxOptions firefoxoptions;// options are certain setting that we can enable or disable to use, that we are setting here.
//instantiate the class
    @Override
    public void setPreferences() {
        firefoxoptions = new FirefoxOptions();



        if (isMaximized()) {
            firefoxoptions.addArguments("start-maximized");//from https://chromedriver.chromium.org/capabilities

        }
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_services", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("excludeSwitches",
                Collections.singletonList("enable-automation"));
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("prefs", prefs);


    }

    @Override
    public WebDriver loadBrowser(String path) {
        WebDriver driver= null;

        System.setProperty("webdriver.gecko.driver", path);
        if (isRemote()) {
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxoptions);

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else{
            driver= new FirefoxDriver(firefoxoptions);// to instantiate and setting prefrences
            if(isMaximized()){
                driver.manage().window().maximize();
            }
            driver.manage().timeouts().pageLoadTimeout(getPageLoadTimeout(), TimeUnit.SECONDS);
            if( isDeleteCookies()){

                driver.manage().deleteAllCookies();
            }

        }
        return driver;

    }
}

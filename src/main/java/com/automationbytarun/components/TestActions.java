package com.automationbytarun.components;

import com.automationbytarun.browser.DriverManager;
import com.automationbytarun.properties.PropertiesLoader;
import com.automationbytarun.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestActions {//contains before and aftermethod
    public WebDriver driver;
    public DriverManager driverManager;
     public BaseActions pageActions;


    @BeforeSuite
    public void setUpConfiguration() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfiguration();//setting up configuration
        driverManager= new DriverManager() ; //initialise the driver


    }
    @BeforeMethod
    public void setUpBrowser() throws Exception {
       driverManager.loadDriver();
       driver=driverManager.getDriver();
       BaseActions pageActions= new BaseActions(driver);
       pageActions.launchUrl(PropertiesLoader.appUrl);// load the app


    }

    @AfterMethod
    public void tearDownBrowser()throws Exception{
        driverManager.closeAllBrowser();
    }

    @AfterSuite
    public void tearDownObjects() throws Exception{
        PropertiesLoader.configProperties= null;
    }
}


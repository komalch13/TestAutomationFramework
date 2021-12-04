package com.automationbytarun.components;

import com.automationbytarun.properties.PropertiesLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class ElementFindBy {
    //creating reuseable elements be using this class.

    WebDriver driver;
    WebDriverWait waitglobalvariable;

    public ElementFindBy(WebDriver driver) {

        this.driver = driver;
        waitglobalvariable = new WebDriverWait(this.driver, PropertiesLoader.explicitWaitTime);// initialised the constructor
    }

    public By findBy(String element) throws IOException, Exception {
        By by;
        RepositoryLoader loader = new RepositoryLoader();
        loader.loadproperties();
        String elementValue = loader.getProperty(element);// element will be the value that will be passed in OR.properties
        String findBy = elementValue.split("")[0];
        String findByValue = elementValue.split("=")[1];
        if (findBy.equalsIgnoreCase("xpath")) {
            by = By.xpath(findByValue);
        } else if (findBy.equalsIgnoreCase("id")) {
            by = By.id(findByValue);

        } else if (findBy.equalsIgnoreCase("name")) {
            by = By.className(findByValue);

        } else if (findBy.equalsIgnoreCase("css")) {
            by = By.cssSelector(findByValue);
        } else {
            throw new Exception("Invalid Locator Type/value in[" + element + "].pls check value in OR file");
        }
        return by;

    }

    public WebElement findElementBy(String element) throws Exception {
        By by = findBy(element);
        return waituntilElementVisible(by);// wait until element is visible the return the element
       // Wait wait = new WebDriverWait(driver, PropertiesLoader.explicitWaitTime);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));// waiting untill the elemenet is visible
       // return driver.findElement(by);// calling driver of findelement by
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("\"//input[@id='search']"))));//until is metghod where we specify the condition, // wait is interface and we are calling webdriver class for interface
        // webdriverwait is a syntax, wait has the method called until that has the condition

    } public List <WebElement> findElementsBy(String element) throws Exception {// find list of elements, not one element
        By by = findBy(element);
        return waituntilallElementsVisible(by);
    }

    public WebElement waituntilElementVisible(By by) throws Exception {
       return waitglobalvariable.until(ExpectedConditions.visibilityOfElementLocated(by));// calling wait.until method

    }

    public List<WebElement> waituntilallElementsVisible(By by) throws Exception {
        return waitglobalvariable.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }


    public WebElement waituntilElementFound(By by) throws Exception {

        return waitglobalvariable.until(ExpectedConditions.presenceOfElementLocated(by));// This is finding the element by , that we are providing then,
        // once the element is found then we are returning the webelement (wait.element)

    }

    public WebElement waituntilelementisclickable(By by) throws Exception{

        return waitglobalvariable.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean waituntilElementIsDisappears(By by)throws Exception{
        return waitglobalvariable.until(ExpectedConditions.invisibilityOfElementLocated(by));
                //if you rare writing by Webelement element then visibilityof will be the method as you are already using element to find,
        //boolean because you are returning true or false

    }

}

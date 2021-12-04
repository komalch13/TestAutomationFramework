package com.automationbytarun.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BaseActions {
    WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;

    }

    public void clickIt(String element) {
        try {

            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(element);
            elementBy.click();
        } catch (Exception e) {

        }
    }

    public void typeIntoTextBox(String elementRef, String text) {
        try {
            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.click();
            elementBy.clear();
            elementBy.sendKeys(text);
        } catch (Exception e) {

        }


    }

    public String getTextFromElement(String elementRef) {
        try {
            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            return elementBy.getText();
        } catch (Exception e) {
            return null;

        }
    }

    public String getAttributeForElement(String elementRef, String attributeType) {
        try {
            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            return elementBy.getAttribute(attributeType);
        } catch (Exception e) {
            return null;
        }

    }

    public void selectValueFromDropdown(String elementRef, String selectBy, String valueToSelect) {
        try {
            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            Select dropDown = new Select(elementBy);
            if (selectBy.equalsIgnoreCase("visibleText")) {
                dropDown.selectByVisibleText(valueToSelect);
            } else if (selectBy.equalsIgnoreCase("value")) {
                dropDown.selectByValue(valueToSelect);
            } else if (selectBy.equalsIgnoreCase("index")) {
                int index = Integer.parseInt(valueToSelect);
                dropDown.deselectByIndex(index);
            }
        } catch (Exception e) {

        }


    }

    public void switchToSecondWindow() {
        try {
            driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
        } catch (Exception e) {
        }

    }

    public void switchToLastWindow() {
        try {
            List<String> windows = new ArrayList<>(driver.getWindowHandles());

            driver.switchTo().window(windows.get(windows.size() - 1));// if size is 4 then window index will be 3 so -1
        } catch (Exception e) {
        }

    }

    public void hitenter(String elementRef) {
        try {
            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.ENTER);
        } catch (Exception e) {

        }

    }

    public void hitTab(String elementRef) {
        try {
            ElementFindBy findobj = new ElementFindBy(driver);
            WebElement elementBy = findobj.findElementBy(elementRef);
            elementBy.sendKeys(Keys.TAB);
        } catch (Exception e) {

        }

    }

    public void launchUrl(String url) {
        try {

            driver.get(url);

        } catch (Exception e) {

        }

    }

    public void refreshPage(String url) {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            new Actions(driver).sendKeys(Keys.F5);
        }

    }

    public void switchToAlertAndAccept() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
        }
    }


    public void switchToAlertAndDismiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
        }
    }


    public void switchToFrame(String elementRef) {
        try {
            ElementFindBy findObj = new ElementFindBy(driver);
            WebElement elementBy = findObj.findElementBy(elementRef);

        } catch (Exception e) {
        }
    }
    public void switchToOriginalPagefromIframe(String elementRef) {
        try {
            driver.switchTo().defaultContent();


        } catch (Exception e) {
        }
    }

    public void scrollToElement(WebElement element){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", element );//if you write true, it will show end of alert box and if you write false, it will show top od alert box which is your element.

        }catch(Exception e){

        }


    }
    public void scrollToTop(){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");//if you write true, it will show end of alert box and if you write false, it will show top od alert box which is your element.

        }catch(Exception e){

        }
    }
    public void scrollToBottom(){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");//if you write true, it will show end of alert box and if you write false, it will show top od alert box which is your element.

        }catch(Exception e){

        }
    }

    public void hoveronTo(String elementRef){
        try{
            ElementFindBy findObj= new ElementFindBy(driver);
            WebElement elementBy= findObj.findElementBy(elementRef);
            new Actions(driver).moveToElement(elementBy).build().perform();
        }catch(Exception e){

        }
    }

    public void dragAndDrop(String elementRef1, String elementRef2){
        try{
            ElementFindBy findObj= new ElementFindBy(driver);
            WebElement elementBy1= findObj.findElementBy(elementRef1);
            WebElement elementBy2= findObj.findElementBy(elementRef2);
            new Actions(driver).dragAndDrop(elementBy1, elementBy2).build().perform();
        }catch(Exception e){

        }
    }

    public void rightClickOnElement(String elementRef){
        try{
            ElementFindBy findObj=new ElementFindBy(driver);
            WebElement elementBy= findObj.findElementBy(elementRef);
            new Actions(driver).contextClick(elementBy).build().perform();
        }catch(Exception e){

        }
    }
    public void doubleClickOnElement(String elementRef){
        try{
            ElementFindBy findObj=new ElementFindBy(driver);
            WebElement elementBy= findObj.findElementBy(elementRef);
            new Actions(driver).doubleClick(elementBy).build().perform();
        }catch(Exception e){

        }
    }

    public Boolean isEnabled(String elementRef){
        try{
            ElementFindBy findObj=new ElementFindBy(driver);
            WebElement elementBy= findObj.findElementBy(elementRef);
            return elementBy.isEnabled();
        }catch(Exception e){
            return false;

        }
    }

    public Boolean isDisplayed(String elementRef){
        try{
            ElementFindBy findObj=new ElementFindBy(driver);
            WebElement elementBy= findObj.findElementBy(elementRef);
            return elementBy.isDisplayed();
        }catch(Exception e){
            return false;

        }
    }


}




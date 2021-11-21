import com.automationbytarun.browser.DriverManager;
import com.automationbytarun.components.ElementFindBy;
import com.automationbytarun.properties.PropertiesLoader;
import com.automationbytarun.properties.PropertiesValidator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleTest {


    @Test

    public void loadBrowserTest()throws Exception{
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfiguration();
        DriverManager driverManager=new DriverManager();
        driverManager.loadDriver();
        DriverManager.driver.get("http://wwww.youtube.com");
        Thread.sleep(3000);
        ElementFindBy findby=new ElementFindBy(DriverManager.driver);
        WebElement element= findby.findElementBy("Youtube.tbx_Username");
        element.sendKeys("Testing Framework");
        Thread.sleep(3000);
        driverManager.closeAllBrowser();



    }
}

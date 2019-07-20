package appium.ejemplo2;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	static AppiumDriver<WebElement> driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capacidades = new DesiredCapabilities();
		capacidades.setCapability("deviceName", "Mi A2");
		capacidades.setCapability("udid", "b77213"); //se saca con adb device
		capacidades.setCapability("platformName", "Android");
		capacidades.setCapability("platformVersion", "9");
		capacidades.setCapability("appPackage", "com.example.myapplication");
		capacidades.setCapability("appActivity", "com.example.myapplication.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		driver = new AppiumDriver<MobileElement>(url, capacidades);
		driver = new AppiumDriver<WebElement>(url, capacidades);
	}
    
    @Test
    public void simpleTest() {
    	System.out.println("Application Started...");
    	
    	driver.findElementById("com.example.myapplication:id/editText").sendKeys("30727345");
    	driver.findElementById("com.example.myapplication:id/button").click();
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElementById("com.example.myapplication:id/ingresa_otp").sendKeys("9511");
    	driver.findElementById("com.example.myapplication:id/button_validar_otpp").click();
    	
    	driver.findElementById("com.example.myapplication:id/spinner_product_type").click();
    	List<WebElement> tarjetas = driver.findElementsByClassName("android.widget.CheckedTextView");
    	tarjetas.get(1).click();
    	driver.findElementById("com.example.myapplication:id/select_button").click();
    	
    	driver.switchTo().frame(driver.findElementByClassName("android.view.ViewGroup"));
    	
//        assertTrue( true );
    }
    
    public void esperar(WebElement elemento) {
    	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(elemento));
    }
}

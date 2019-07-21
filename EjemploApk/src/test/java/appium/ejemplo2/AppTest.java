package appium.ejemplo2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private static AppiumDriver<WebElement> driver;
	
	private By numeroCedulaField = By.id("editText");
	private By numeroOtpField = By.id("ingresa_otp");
	private By generarWidgetButton = By.id("button");
	private By enviarOtpButton = By.id("button_validar_otpp");
	private By seleccionarButton = By.id("select_button");
	private By abrirListaDeProductos = By.id("spinner_product_type");
	private By tarjetasSelect = By.className("android.widget.CheckedTextView");
	
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
    	
    	driver.findElement(numeroCedulaField).sendKeys("30727345");
    	driver.findElement(generarWidgetButton).click();
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(numeroOtpField).sendKeys("9511");
    	driver.findElement(enviarOtpButton).click();
    	
    	driver.findElement(abrirListaDeProductos).click();
    	List<WebElement> listaDeTarjetas = driver.findElements(tarjetasSelect);
    	listaDeTarjetas.get(1).click();
    	driver.findElement(seleccionarButton).click();
    	
    }
    
    public void esperar(WebElement elemento) {
    	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(elemento));
    }
}

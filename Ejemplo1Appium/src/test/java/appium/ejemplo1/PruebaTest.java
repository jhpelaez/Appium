package appium.ejemplo1;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PruebaTest {

	static AppiumDriver<MobileElement> driver;
	
	@Test
	public void test() {
		try {
			openCalculator();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//driver.findElement(By.id("edtno1")).sendKeys(""); //para id corto
	//driver.findElementById("com.example:id/edtno1"); //para id largo
	
	//************************CLIC SOSTENIDO********************************
	//WebElement zero = driver.findElementById("")
	//TouchAction action = new TouchAction(driver);
	//action.longPress(zero).perform();
	//**********************************************************************
	
	public static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Mi A2");
		cap.setCapability("udid", "b77213");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started...");
		
//		driver.findElement(By.id("digit_5")).click();
//		driver.findElement(By.id("digit_1")).click();
//		driver.findElement(By.id("op_add")).click();
//		driver.findElement(By.id("digit_4")).click();
//		driver.findElement(By.id("eq")).click();
//		
//		String result = driver.findElement(By.id("result")).getText();
//		if ("55".equals(result))
//			System.out.println("PASSED");
//		else
//			System.out.println("FAILED");
		
		
		
	}

}

package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Base {
	
	public static AppiumDriver<MobileElement> driver;
	private static  WebDriverWait wait;
	
	Properties prop = new Properties();
	InputStream input;
    
	public void doSetUp() throws IOException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		String CurrentDirectory = System.getProperty("user.dir");
				
		try {
			input = new FileInputStream(new File(CurrentDirectory+"\\common.properties"));
			prop.load(input);
			String deviceID = prop.getProperty("DEVICEID");
			System.out.println(deviceID);
			
			capabilities.setCapability("deviceID", prop.getProperty("DEVICEID"));
			capabilities.setCapability("platform", prop.getProperty("PLATFOMRM"));
			capabilities.setCapability("deviceName",prop.getProperty("DEVICENAME"));
			capabilities.setCapability("deviceVersion",prop.getProperty("DEVICEVERSION"));
			capabilities.setCapability("appPackage", prop.getProperty("APPPACKAGE"));
			capabilities.setCapability("appActivity", prop.getProperty("APPACTIVITY"));
			capabilities.setCapability("newCommandTimeout", "60");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	try {
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 30);
	}
	catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public WebElement findElement(By by)
	{
		 	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		 	return element;
	}
	public void click(By by)
	{
		WebElement element = findElement(by);
		
		if(element!=null)
		{
			element.click();
		}
	}
	public void waitForInvibilityOfElement(By by) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

		} catch (Exception e) {
		}

	}
	
	public List<MobileElement> findElements(By bys) {
		List<MobileElement>element = findElements(bys);
		return element;
	}
	public void verifyTextPresent(By by, String inputText)
	{
		Boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(by, inputText));
	}
	public void sendkeysToTextBox(By by, String inputText)
	{
		WebElement element = findElement(by);
		if(element!=null)
		{
			element.clear();
			element.sendKeys(inputText);
		}
	}
	public static void swipeFullScreen() {
		try {
			Dimension size = driver.manage().window().getSize();
			int starty = (int) (size.height * 0.70);
			int endy = (int) (size.height * 0.30);
			int startx = size.width / 2;
			new TouchAction<>(driver).longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	public void tearDown()
	{
		driver.quit();
	}
}

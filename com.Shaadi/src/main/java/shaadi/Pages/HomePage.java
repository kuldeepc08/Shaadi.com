package shaadi.Pages;

import java.util.List;

import org.openqa.selenium.By;

import base.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomePage extends Base {
//	private static By HOME_BUTTON = By.xpath("//android.widget.TextView[@text='Home']");
	private static By HOME_BUTTON = By.id("tvMyShaadi");
	private static By SHAADI_TEXT = By.id("tvDashboard");
	private static By PREMIUM_TEXT = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Premium Matches\")");
	private static By CONNECT_BUTTON = By.id("llConnect");
	private static By CROSS_BUTTON = By.id("iv_cancel");
	private static By NEW_MATCHES_TEXT  = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"New Matches\")");
	
	public void clickHomeButton()
	{
		waitForInvibilityOfElement(HOME_BUTTON);
		click(HOME_BUTTON);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String verifyShaadiTextisPresent()
	{
		waitForInvibilityOfElement(SHAADI_TEXT);
		return findElement(SHAADI_TEXT).getText();	
	}
	public String verifyPremiumTextisPresent()
	{
		return findElement(PREMIUM_TEXT).getText();	
	}
	public String verifyNewMatchesTextisPresent()
	{
		return findElement(NEW_MATCHES_TEXT).getText();	
	}

	public void clickConnectButton()
	{
		click(CONNECT_BUTTON);
	}
	public void clickCrossButton()
	{
		List<MobileElement>crossButton = driver.findElements(CROSS_BUTTON);
		
		if (crossButton.size()!=0) {
			crossButton.get(0).click();
		}
	}
	
	
}

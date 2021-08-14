package shaadi.Testcases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;

public class LoginTest extends TestBase {
	
	@Parameters({"username","password"})
	@Test(description="This test case will perform login related validation")
	public void Verify_Login(String username, String password)
	{
		pages.getLoginpage().click_LoginButton();
		Assert.assertTrue(pages.getLoginpage().getWelComeText(),"Welcome Text is not displayed");
		pages.getLoginpage().doLogin(username, password);
	}
}

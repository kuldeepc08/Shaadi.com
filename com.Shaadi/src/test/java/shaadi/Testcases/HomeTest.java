package shaadi.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;
import base.TestBase;

public class HomeTest extends TestBase{
	
	Base base;

	@Test(priority =1,description="This test case is to perform Validation on Home screen")
	public void Verify_HomePage()
	{
		pages.getHomepage().clickHomeButton();
		String homeHeader = pages.getHomepage().verifyShaadiTextisPresent();
		String homeHeaderExpected = "My Shaadi";
		Assert.assertEquals(homeHeader, homeHeaderExpected);
	}
	
	@Test(priority =2 ,description="This test case is to perform Validation on Premium Widget")
	public void Verify_PremiumWidget()
	{
		pages.getHomepage().clickHomeButton();
		String premiumHeader = pages.getHomepage().verifyPremiumTextisPresent();
		String premiumText = premiumHeader.replaceAll("[^a-zA-Z]"," ");
		String premiumMatchedHeaderExpected = "Premium Matches";
		Assert.assertEquals(premiumText.trim(), premiumMatchedHeaderExpected, "Text does not matched");
		Base.swipeFullScreen();
		pages.getHomepage().clickConnectButton();
		pages.getHomepage().clickCrossButton();	
	}
	@Test(priority =3,description="This test case is to perform Validation on New Matches Widget")
	public void Verify_NewMatchesWidget()
	{
		Base.swipeFullScreen();
		String newMatchesHeader = pages.getHomepage().verifyNewMatchesTextisPresent();
		String newMatch = newMatchesHeader.replaceAll("[^a-zA-Z]"," ");
		System.out.println("Removed number -" +newMatch.trim());
	
		String newMatchesHeaderExpected = "New Matches";				
		
		Assert.assertEquals(newMatch.trim(), newMatchesHeaderExpected, "Screen header not matched");
		pages.getHomepage().clickConnectButton();
		pages.getHomepage().clickCrossButton();
	}
}

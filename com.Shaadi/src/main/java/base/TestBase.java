package base;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public Base base = new Base();
	public PageFactory pages ;

	@BeforeTest
	public void beforeTest() throws IOException
	{
		base.doSetUp();
	}
	@BeforeClass
	public void beforeclass()
	{
		pages = new PageFactory();
	}
	@AfterTest
	public void afterTest()
	{
		base.tearDown();
	}
}

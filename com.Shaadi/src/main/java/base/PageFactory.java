package base;

import shaadi.Pages.HomePage;
import shaadi.Pages.LoginPage;

public class PageFactory {
	
	private LoginPage loginpage;
	private HomePage homepage;
	public PageFactory()
	{
		setLoginpage(new LoginPage());
		setHomepage(new HomePage());
	}

	public HomePage getHomepage() {
		return homepage;
	}

	public void setHomepage(HomePage homepage) {
		this.homepage = homepage;
	}

	public LoginPage getLoginpage() {
		return loginpage;
	}

	public void setLoginpage(LoginPage loginpage) {
		this.loginpage = loginpage;
	}

	
}

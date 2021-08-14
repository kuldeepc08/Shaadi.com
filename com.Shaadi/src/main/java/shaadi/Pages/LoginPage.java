package shaadi.Pages;

import org.openqa.selenium.By;


import base.Base;

public class LoginPage extends Base{
	
	private static By Login_Button = By.id("btn_morph_login");
	private static By Welcome_Text =By.id("tv_heading");
	private static By UserName_TextBox = By.id("edt_username");
	private static By Password_TextBox = By.id("edt_password");
	private static By ShowPassword_Btn = By.id("tv_hide_show_password");
	private static By Login_Screen_Login_Button = By.id("btn_login");
	

	public void click_LoginButton()
	{
		click(Login_Button);
	}
	public boolean getWelComeText()
	{
		return findElement(Welcome_Text).isDisplayed(); 
	}
	public void enter_UserName(String username)
	{
		sendkeysToTextBox(UserName_TextBox, username);
	}
	public void enter_Password(String password )
	{
		sendkeysToTextBox(Password_TextBox, password);
	}
	public void click_ShowPasswordButton()
	{
		click(ShowPassword_Btn);
	}
	public void click_LoginScreen_LoginButton()
	{
		click(Login_Screen_Login_Button);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doLogin(String userName, String Password)
	{	
		enter_UserName(userName);
		enter_Password(Password);
		click_ShowPasswordButton();
		click_LoginScreen_LoginButton();
	}
	
}

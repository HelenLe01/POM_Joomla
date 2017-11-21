package pages;

import org.openqa.selenium.WebDriver;

import joomla.LoginUI;
import pages.Abstract_Page;

public class LoginPage extends Abstract_Page{
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	public void typeToUserName(String username) {
		sendkeyToElement(driver, LoginUI.UserName_Text, username);
		
	}
	public void typeToPassword(String password) {
		sendkeyToElement(driver, LoginUI.Password_Text, password);
		
	}

}

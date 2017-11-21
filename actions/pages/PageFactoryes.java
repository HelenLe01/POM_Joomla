package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryes {
	WebDriver driver;

	public static LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}

	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);
	}

	public static AddNewArticlePage getAddNewArticlePage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AddNewArticlePage(driver);
	}

	public static DashBoardPage getDashBoardPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new DashBoardPage(driver);
	}

	public static EditArticlePage getEditArticlePage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new EditArticlePage(driver);
	}
}

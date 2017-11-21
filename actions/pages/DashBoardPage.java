package pages;

import org.openqa.selenium.WebDriver;

import joomla.DashBoardPageUI;

public class DashBoardPage extends Abstract_Page{
	WebDriver driver;
	public DashBoardPage(WebDriver driver){
		this.driver=driver;
	}
	public String getMsg() {
		return getTextOfElement(driver, DashBoardPageUI.Message_Label);
	}

}

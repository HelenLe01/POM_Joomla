package pages;

import org.openqa.selenium.WebDriver;

import joomla.AbstractPageUI;
import joomla.DashBoardPageUI;

public class DashBoardPage extends Abstract_Page{
	WebDriver driver;
	public DashBoardPage(WebDriver driver){
		this.driver=driver;
	}
	public String getMsg() {
		return getTextOfElement(driver, DashBoardPageUI.Message_Label);
	}
	public void checkCheckBox(String title) {
		clickToElement(driver, AbstractPageUI.dynamicCheckBox, title);
		
	}
	public void clickToPublishBtn() {
		clickToElement(driver, DashBoardPageUI.Publish_Btn);
		
	}
	public void clickToUserMenu() {
		clickToElement(driver, DashBoardPageUI.UserMenu);
		
	}
	public void clickToUnpublishBtn() {
		clickToElement(driver, DashBoardPageUI.Unpublish_Btn);
		
	}
	public void clickToArchivedBtn() {
		clickToElement(driver, DashBoardPageUI.Archived_Btn);
		
	}
	public void clickToSearchBtn() {
		clickToElement(driver, DashBoardPageUI.Search_Btn);
		
	}
	public void selectStatus() {
		clickToElement(driver, DashBoardPageUI.SelectStatus);
		
	}
	public void selectArchived() {
		clickToElement(driver, DashBoardPageUI.ArchivedStatus);
		
	}
	public void clickToCheckinBtn() {
		clickToElement(driver, DashBoardPageUI.Checkin_Btn);
		
	}
	


}

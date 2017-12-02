package pages;

import org.openqa.selenium.WebDriver;

import joomla.DashBoardPageUI;
import joomla.EditArticlePageUI;

public class EditArticlePage extends Abstract_Page{
	WebDriver driver;
	public EditArticlePage (WebDriver driver){
		this.driver=driver;
	}
	public void typeToTitle(String title) {
		sendkeyToElement(driver, EditArticlePageUI.Title_Text, title);
		
	}
	public void clickToCategory() {
		clickToElement(driver, EditArticlePageUI.Catogoty_DropDown);
		
	}
	public void selectAutomationValue() {
		clickToElement(driver, EditArticlePageUI.Automation_Option);
		
	}
	public void swicthToFrame() {
		switchToIframeByID(driver, EditArticlePageUI.TextAreaIframe);
		
	}
	public void typeToDetailNewArticle(String value) {
		sendkeyToBody(driver, EditArticlePageUI.Tagname, value);
		
	}
	public void waitToDetail() {
		waitForControlVisible(driver, EditArticlePageUI.TextArea);
		
	}
	public void clickToTextArea() {
		clickToElement(driver, EditArticlePageUI.TextArea);
		
	}
	public void closeBrowser() {
		closeBrowser(driver);
		
	}
	public String getMsg() {
		return getTextOfElement(driver, EditArticlePageUI.Message_Label);
	}

}

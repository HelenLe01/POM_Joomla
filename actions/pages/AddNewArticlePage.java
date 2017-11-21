package pages;

import org.openqa.selenium.WebDriver;

import joomla.AddNewArticlePageUI;

public class AddNewArticlePage extends Abstract_Page{
	WebDriver driver;
	public AddNewArticlePage(WebDriver driver){
		this.driver= driver;
	}
	public void typeToTitle(String title) {
		sendkeyToElement(driver, AddNewArticlePageUI.Title_Text, title);
		
	}
	public void clickToCategory() {
		clickToElement(driver, AddNewArticlePageUI.Catogoty_DropDown);
		
	}
	public void selectAutomationValue() {
		clickToElement(driver, AddNewArticlePageUI.Automation_Option);
		
	}
	public void swicthToFrame() {
		switchToIframeByID(driver, AddNewArticlePageUI.TextAreaIframe);
		
	}
	public void typeToDetailNewArticle(String value) {
		sendkeyToBody(driver, AddNewArticlePageUI.Tagname, value);
		
	}
	public void waitToDetail() {
		waitForControlVisible(driver, AddNewArticlePageUI.TextArea);
		
	}
	public void clickToTextArea() {
		clickToElement(driver, AddNewArticlePageUI.TextArea);
		
	}
}

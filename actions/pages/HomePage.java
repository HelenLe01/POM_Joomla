package pages;

import org.openqa.selenium.WebDriver;

import joomla.HomePageUI;
import pages.Abstract_Page;
public class HomePage extends Abstract_Page{
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	public void clickToContent() {
		clickToElement(driver, HomePageUI.Content_Link);
		
	}
	public void hoverToArticle() {
		hoverMouse(driver, HomePageUI.Article_Link);
	}
	public void waitToContentVisiable() {
		waitForControlVisible(driver, HomePageUI.Content_Link);
		// TODO Auto-generated method stub
		
	}
	public void waitToArticleVisiable() {
		waitForControlVisible(driver, HomePageUI.Article_Link);
		// TODO Auto-generated method stub
		
	}
	public void waithToNewArticleVisiable() {
		waitForControlVisible(driver, HomePageUI.NewArticle_Link);
		// TODO Auto-generated method stub
		
	}
	public void hovetToNewArticle() {
		hoverMouse(driver, HomePageUI.NewArticle_Link);
		
	}

}

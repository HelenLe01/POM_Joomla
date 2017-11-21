package pages;


import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import joomla.AbstractPageUI;
import joomla.AddNewArticlePageUI;
import joomla.HomePageUI;
import joomla.LoginUI;



public class Abstract_Page {
	WebDriver driver;

	// WebBrowser

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	// WebELement

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	public void clickToElement(WebDriver driver, String locator, String value) {
		locator= String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void sendkeyToBody(WebDriver driver, String tagname, String value){
		WebElement element= driver.findElement(By.cssSelector(tagname));
		element.clear();
		element.sendKeys(value);
	}
	
	public String getTextOfElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getAttributeOFElement(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isElementSlected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public void selectByVisibleText(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);	
	}
	
	public void selectByValue(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByValue(value);
	}

	public boolean getFirstSelectedText(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
		String actual = select.getFirstSelectedOption().getText();
		return value.equals(actual);
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}
//alert
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextOfAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			if (!childWindows.equals(parent)) {
				driver.switchTo().window(childWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}
	
	public void switchToIframeByID(WebDriver driver, String id) {
		WebElement element = driver.findElement(By.id(id));
		driver.switchTo().frame(element);
	}
	public void switchToDefault(WebDriver driver){
		driver.switchTo().defaultContent();
	}

	public void doubleClick(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath(locator)));
	}

	public void hoverMouse(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath(locator)));
	}

	public void dragAndDrop(WebDriver driver, String sourcelocator, String targetlocator2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(By.xpath(sourcelocator)), driver.findElement(By.xpath(targetlocator2)));
	}

	public void keyPress(WebDriver driver, String keyvalue) {
		Actions action = new Actions(driver);
		action.sendKeys(keyvalue);
	}

	public void uploadBySendKey(WebDriver driver, String locator, String filePath) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(filePath);
	}

	public void uploadByRobot(WebDriver driver, String locator, String filePath) throws Exception {
		StringSelection select = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public Object executeJavaSriptForBrowser(WebDriver driver, String javascript) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			return je.executeScript(javascript);

		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	public Object executeJavaScriptForElement(WebDriver driver, String javascript, String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor je = (JavascriptExecutor) driver;
			return je.executeScript(javascript, element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottom(WebDriver driver) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			return je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToTop(WebDriver driver) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			return je.executeScript("window.scrollTo(0, 0)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public void waitForControlPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		locator= String.format(locator, value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void waitForControlClickabe(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void waitForControlNotVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void assertEqualsString(WebDriver driver, String locator, String expectedVaule){
		String actualValue= driver.findElement(By.xpath(locator)).getText();
		assertEquals(actualValue, expectedVaule);
	}
	
	public Object removeAttributeInDOM(WebDriver driver, String locator, String attribute){
		try{
			WebElement element= driver.findElement(By.xpath(locator));
			JavascriptExecutor js= (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('"+attribute+"');", element);
			
		}catch(Exception e){
			e.getMessage();
			return null;
		}
	}	
	public HomePage clickToLoginBtn(WebDriver driver) {
		clickToElement(driver, LoginUI.Login_Btn);
		return PageFactoryes.getHomePage(driver);
		
	}
	
	public AddNewArticlePage clickToNewArtitcle(WebDriver driver) {
		executeJavaScriptForElement(driver, "arguments[0].click();", HomePageUI.NewArticle_Link);
		return PageFactoryes.getAddNewArticlePage(driver);
	}
	
	public DashBoardPage clickToSaveandCloseBtn(WebDriver driver) {
		clickToElement(driver, AddNewArticlePageUI.SaveandClose_Btn);
		return PageFactoryes.getDashBoardPage(driver);		
	}
	public EditArticlePage editCreatedArticle(WebDriver driver,String title) {
		clickToElement(driver, AbstractPageUI.dynamicTitle, title);	
		return PageFactoryes.getEditArticlePage(driver);
	}
}

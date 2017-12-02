package com.joomla.login;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.AddNewArticlePage;
import pages.DashBoardPage;
import pages.EditArticlePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PageFactoryes;
import pages.constant;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class TC01_CreateNewArticle extends AbstractTest {
	WebDriver driver;
	private String username, password, title, value, actual, expected, title1, value1, actualPublishMsg,
			expectedPublishMsg, newTitle, titleTC03, titleTC04, expectedUnPublishMsg, titleTC05,titleTC06,expectedCheckedInMsg, 
			expectedArchivedMsg, status;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver = openBrowser(browser, url);
		loginPage = PageFactoryes.getLoginPage(driver);
		username = constant.username;
		password = constant.password;
		title = "New Challenge" + " " + randomString();
		newTitle = "New Article" + " " + randomString();
		title1 = "New Changes" + " " + randomString();
		titleTC03 = "Automation" + " " + randomString();
		titleTC04 = "New Technology" + " " + randomString();
		titleTC05 = "Selenium" + " " + randomString();
		titleTC06 = "Selenium" + " " + randomString();
		value = "The standalone Selenium Server acts as a proxy between your script and the browser-specific drivers.";
		expected = "Article saved.";
		value1 = "abc";
		expectedPublishMsg = "1 article published.";
		expectedUnPublishMsg="1 article unpublished.";
		expectedArchivedMsg="1 article archived.";
		expectedCheckedInMsg="1 article checked in.";
		status="Published";
	}

//	@Test
	public void TC01_CreateSuccessfullyNewArticle() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage = homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(title);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);
		dashboard = addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual = dashboard.getMsg();
		verifyEquals(actual, expected);
		dashboard.verifyRecordExistedInTable(driver,title);
		dashboard.clickToUserMenu();
		dashboard.clickToLogOut(driver);
	}
//	@Test
	public void TC02_EditSuccessfullyArticle() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage = homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(newTitle);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);
		dashboard = addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual = dashboard.getMsg();
		verifyEquals(actual, expected);
		dashboard.verifyRecordExistedInTable(driver,newTitle);
		editArticlePage = dashboard.editCreatedArticle(driver, newTitle);
		editArticlePage.typeToTitle(title1);
		editArticlePage.clickToCategory();
		editArticlePage.selectAutomationValue();
		editArticlePage.swicthToFrame();
		editArticlePage.waitToDetail();
		editArticlePage.typeToDetailNewArticle(value1);
		editArticlePage.switchToDefault(driver);
		dashboard = editArticlePage.clickToSaveandCloseBtn(driver);
		actual = dashboard.getMsg();
		verifyEquals(actual, expected);
		dashboard.verifyRecordExistedInTable(driver,title1);
		dashboard.clickToUserMenu();
		dashboard.clickToLogOut(driver);
	}

//	@Test
	public void TC03_PublishArticleSuccessfully() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage = homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(titleTC03);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);
		dashboard = addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual = dashboard.getMsg();
		verifyEquals(actual, expected);
		dashboard.checkCheckBox(titleTC03);
		dashboard.clickToPublishBtn();
		actualPublishMsg = dashboard.getMsg();
		verifyEquals(actualPublishMsg, expectedPublishMsg);
		dashboard.verifyRecordExistedInTable(driver,titleTC03);
		dashboard.clickToUserMenu();
		dashboard.clickToLogOut(driver);
	}
	
//	@Test
	public void TC04_UnpublishArticleSuccessfully() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage = homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(titleTC04);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);
		dashboard = addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual = dashboard.getMsg();
		verifyEquals(actual, expected);
		dashboard.checkCheckBox(titleTC04);
		dashboard.clickToUnpublishBtn();
		actual = dashboard.getMsg();
		verifyEquals(actual, expectedUnPublishMsg);
		dashboard.verifyRecordExistedInTable(driver,titleTC04);
		dashboard.clickToUserMenu();
		dashboard.clickToLogOut(driver);
	}
//	@Test
	public void TC05_ArchivedArticleSuccessfully() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage = homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(titleTC05);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);
		dashboard = addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual = dashboard.getMsg();
		verifyEquals(actual, expected);
		dashboard.checkCheckBox(titleTC05);
		dashboard.clickToArchivedBtn();
		actual = dashboard.getMsg();
		verifyEquals(actual, expectedArchivedMsg);
		dashboard.clickToSearchBtn();
		dashboard.selectStatus();
		dashboard.selectArchived();
		dashboard.verifyRecordExistedInTable(driver,titleTC05);
		dashboard.clickToUserMenu();
		dashboard.clickToLogOut(driver);
	}
	@Parameters({ "browser", "url" })
	@Test
	public void TC06(String browser, String url) {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage = homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(titleTC06);
		addNewArticlePage.selectStatus(status);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);
		editArticlePage = addNewArticlePage.clickToSaveBtn(driver);
		actual= editArticlePage.getMsg();
		verifyEquals(actual, expected);
		editArticlePage.closeBrowser();
		driver = openBrowser(browser, url);
		loginPage = PageFactoryes.getLoginPage(driver);
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLoginBtn(driver);
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		dashboard= homePage.clickToArtitcle(driver);
		dashboard.checkCheckBox(titleTC06);
		dashboard.clickToCheckinBtn();
		actual = dashboard.getMsg();
		verifyEquals(actual, expectedCheckedInMsg);
		dashboard.clickToUserMenu();
		dashboard.clickToLogOut(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	private LoginPage loginPage;
	private HomePage homePage;
	private AddNewArticlePage addNewArticlePage;
	private DashBoardPage dashboard;
	private EditArticlePage editArticlePage;

	public String randomString() {
		Random rand = new Random();
		int number = rand.nextInt(900) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}
}

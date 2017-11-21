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
	private String username, password, title, value, actual, expected,title1, value1;
	@Parameters({"browser","url"})
	
	@BeforeClass
	public void beforeClass(String browser, String url) {
		driver=openBrowser(browser, url);
		loginPage=PageFactoryes.getLoginPage(driver);
		username=constant.username;
		password= constant.password;
		title="New Challenge"+" "+ randomString();
		title1="New Challenge"+" "+ randomString();
		value="The standalone Selenium Server acts as a proxy between your script and the browser-specific drivers.";
		expected="Article saved.";
		value1="abc";
	}

//	@Test
	public void TC01_CreateSuccessfullyNewArticle() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage=loginPage.clickToLoginBtn(driver);	
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage=homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(title);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);		
		dashboard=addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual=dashboard.getMsg();
		verifyEquals(actual, expected);
		
	}
	@Test
	public void TC02_EditSuccessfullyArticle() {
		loginPage.typeToUserName(username);
		loginPage.typeToPassword(password);
		homePage=loginPage.clickToLoginBtn(driver);	
		homePage.waitToContentVisiable();
		homePage.clickToContent();
		homePage.waitToArticleVisiable();
		homePage.hoverToArticle();
		addNewArticlePage=homePage.clickToNewArtitcle(driver);
		addNewArticlePage.typeToTitle(title);
		addNewArticlePage.clickToCategory();
		addNewArticlePage.selectAutomationValue();
		addNewArticlePage.swicthToFrame();
		addNewArticlePage.waitToDetail();
		addNewArticlePage.typeToDetailNewArticle(value);
		addNewArticlePage.switchToDefault(driver);		
		dashboard=addNewArticlePage.clickToSaveandCloseBtn(driver);
		actual=dashboard.getMsg();
		verifyEquals(actual, expected);
		editArticlePage= dashboard.editCreatedArticle(driver,title);
		editArticlePage.typeToTitle(title1);
		editArticlePage.clickToCategory();
		editArticlePage.selectAutomationValue();
		editArticlePage.swicthToFrame();
		editArticlePage.waitToDetail();
		editArticlePage.typeToDetailNewArticle(value1);
		editArticlePage.switchToDefault(driver);		
		dashboard=editArticlePage.clickToSaveandCloseBtn(driver);
		actual=dashboard.getMsg();
		verifyEquals(actual, expected);
		
		
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

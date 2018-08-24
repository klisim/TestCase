package com.kurs.selenium.przyklad1;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test10 {
	
	private WebDriver driver;
	boolean  isElementPresent;
	@Before
	public void setUp() {
		// odpal Firefoxa
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
	}
	
	@After
	public void tearDown() throws Exception {
		// zamknij przeglądarkę
		 driver.quit();
	}	
	
	@Test
	public void testIsUserSuccessfullyCreated() {
		// dane testowe
		String firstName = "Jan";
		String lastName = "Kowalski";
		String address = "Wrocław";
		String email = "mail@test.com";
		String password = "123456";
		String company = "CodersLab";
		String comment = "First test case";
		
		// lokatory
		String firstNameLocator = "first-name";
		String lastNameLocator = "last-name";
		String genderLocator = "/html/body/div/div/form/div[3]/div/div/label[3]/input";
		String dateOfBirthLocator = "dob";
		String calendarLocator = "/html/body/div[2]/div[1]/table/tbody/tr[3]/td[4]";
		String addressLocator = "address";
		String emailLocator = "email";
		String roleLocator = "role";
		String jobLocator = "expectation";
		String companyLocator = "company";
		String passwordLocator = "password";
		String checkboxLocator = "//*[@id='infoForm']/div[11]/div/div[1]/label/input";
		String commentLocator = "comment";
		String submitLocator = "submit";

		// wpisz imie
		
		
		WebElement firstNameElement = driver.findElement(By.id(firstNameLocator));
		isElementPresent = firstNameElement.isEnabled();
		System.out.println("Element is enabled: " + isElementPresent + "\n" + firstNameElement.getAttribute("name") + ": " + firstName);
		//Wypisz z konsoli text elementu
		
		firstNameElement.isEnabled();
		firstNameElement.clear();
		firstNameElement.sendKeys(firstName);
		
		// wpisz nazwisko
		WebElement lastNameElement = driver.findElement(By.id(lastNameLocator));
		isElementPresent = lastNameElement.isEnabled();
		System.out.println("Element is enabled: " + isElementPresent + "\n" + lastNameElement.getAttribute("name") + ": " + lastName);

		lastNameElement.clear();
		lastNameElement.sendKeys(lastName);
		
		//kliknij płeć
		WebElement genderElement = driver.findElement(By.xpath(genderLocator));
		isElementPresent = genderElement.isEnabled();
		System.out.println("Click is possible: " + isElementPresent + "\n" + genderElement.getAttribute("name")+ ": " + genderElement);
		genderElement.click();
		
		//wybierz datę urodzin
		WebElement dobElement = driver.findElement(By.id(dateOfBirthLocator));
		dobElement.click();
		WebElement calendarElement = driver.findElement(By.xpath(calendarLocator));
		calendarElement.click();

		// wpisz adres
		WebElement addressElement = driver.findElement(By.id(addressLocator));
		addressElement.click();
		addressElement.clear();
		addressElement.sendKeys(address);
		
		// wpisz email
		WebElement emailElement = driver.findElement(By.id(emailLocator));
		emailElement.clear();
		emailElement.sendKeys(email);
		
		// wpisz hasło
		WebElement passwordElement = driver.findElement(By.id(passwordLocator));
		passwordElement.clear();
		passwordElement.sendKeys(password);
		
		// wpisz firmę
		WebElement companyElement = driver.findElement(By.id(companyLocator));
		companyElement.clear();
		companyElement.sendKeys(company);
		
		// wybierz rolę QA
		Select roleDropdown = new Select (driver.findElement(By.id(roleLocator)));
		roleDropdown.selectByVisibleText("QA");
		
		// wybierz rolę QA
		Select jobExpectationSelect = new Select (driver.findElement(By.id(jobLocator)));
		jobExpectationSelect.selectByVisibleText("High salary");
		jobExpectationSelect.selectByVisibleText("Excellent colleagues");
		
		// wybierz development checkbox
		WebElement readBooksCheckbox = driver.findElement(By.xpath(checkboxLocator));
		readBooksCheckbox.click();
		
		// wpisz komentarz
		WebElement commentElement = driver.findElement(By.id(commentLocator));
		commentElement.clear();
		commentElement.sendKeys(comment);				
		
		// kliknij submit
		WebElement submitButton = driver.findElement(By.id(submitLocator));
		submitButton.click();		
		
		//sprawdz czy uzytkowanik zostal zalozony
		WebElement submitMessage = driver.findElement(By.id("submit-msg"));
		String result = submitMessage.getText();
		assertEquals ("Successfully submitted!", result);
		
		
	}
	
}
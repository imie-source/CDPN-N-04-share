package fr.imie;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TrelloMainTest {

	static WebDriver driver;
	static SimonVariable simonVariable;
	String boardTitle = "testJunit";

	public TrelloMainTest() {
		super();

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		simonVariable = new SimonVariable();
		driver.get("https://trello.com/login");
		driver.findElement(By.id("user")).clear();
		driver.findElement(By.id("user"))
				.sendKeys("simon.louvet.zen@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(
				simonVariable.getPassword());
		driver.findElement(By.id("login")).click();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testLogin() {
		// Arrange
		goHome();
		// Act
		// Assert
		WebElement loginUser = driver.findElement(By
				.cssSelector("span.header-btn-text.js-member-name"));
		assertEquals(loginUser.getText(), "simon");

	}

//	@Test
//	public void testDeleteBoard() {
//		//Arrange
//		goHome();
//		createBoard();
//		goHome();
//		//Act
//		deleteAllJunitBoard();
//		//Assert
//		assertEquals(0, driver.findElements(By.xpath("//span[text()='testJunit']")).size());
//	}
	
//	@Test
//	public void testCreateBoard() {
//
//		// Arrange
//		goHome();
//		// Act
//		createBoard();
//		// Assert
//		assertEquals(
//				boardTitle,
//				driver.findElement(By.cssSelector("span.board-header-btn-text"))
//						.getText());
//		//Back
//		goHome();
//		deleteAllJunitBoard();
//		
//	}
	


	private void createBoard() {
		driver.findElement(By.xpath("//div[@id='header']/div[4]/a/span"))
				.click();
		driver.findElement(By.cssSelector("a.js-new-board")).click();
		driver.findElement(By.id("boardNewTitle")).sendKeys(boardTitle);
		driver.findElement(By.xpath("//input[@value='Create']")).click();
	}

	private void goHome() {
		driver.get("https://trello.com/");
	}



	private void deleteAllJunitBoard() {
		while (driver.findElements(By.xpath("//span[text()='testJunit']")).size()>0) {
			driver.findElement(By.xpath("//span[text()='testJunit']")).click();

			driver.findElement(
					By.xpath("//h3[contains(text(),'Menu')]"))
					.click();
			driver.findElement(By.linkText("Close Board…")).click();
			driver.findElement(By.xpath("//input[@value='Close']")).click();
			goHome();
		}
	}

}

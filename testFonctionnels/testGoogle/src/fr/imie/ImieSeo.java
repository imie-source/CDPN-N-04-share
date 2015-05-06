package fr.imie;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImieSeo {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		// Arrange
		driver = new FirefoxDriver();
		driver.get("http://google.fr");
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("IMIE");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);

		WebElement imieLink = locateElementAfterAppear(By
				.linkText("IMIE | Ecole de la Filière Numérique"));

		// Act
		imieLink.click();

		// Assert
		assertTrue(driver.findElement(By.xpath("//body")).getText()
				.matches("^[\\S\\s]*IT START[\\S\\s]*$"));

		driver.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private WebElement locateElementAfterAppear(By by) {
		return (new WebDriverWait(driver, 1)).until(ExpectedConditions
				.presenceOfElementLocated(by));

	}

}

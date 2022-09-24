package helpers;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static steps.StepsHooks.driver;

public class BasePage {

	public static String currentLanguage = "";

	public static void ClickOnElementViaElementID(String elementId) throws Exception {
		String locator = "//*[@id='" + elementId + "']";
		ClickOnElementViaElementXpath(locator);
	}

	public static void ClickOnElementViaElementXpath(String locator) throws Exception {
		WaitForWebElementViaXpathLocator(locator);
		ConsoleWrite("Click on element with locator: " + locator);
		WebElement element = driver.findElement(By.xpath(locator));
		ClickOnElementViaWebElement(element);
	}

	public static void ClickOnElementViaWebElement(WebElement element) throws Exception {
		element.click();
		Thread.sleep(1000);
	}

	public static void AssertWebElementExistsViaElementID(String elementId) throws Exception {
		String locator = "//*[@id='" + elementId + "']";
		if (!WaitForWebElementViaXpathLocator(locator)) {
			throw new Exception("Element with element id: " + elementId + " is not present on the page!");
		}
	}

	public static void AssertWebElementExistsViaXpathLocator(String locator) throws Exception {
		if (!WaitForWebElementViaXpathLocator(locator)) {
			throw new Exception("Element with locator: " + locator + " is not present on the page!");
		}
	}

	public static boolean WaitForWebElementViaElementID(String elementId) {
		String locator = "//*[@id='" + elementId + "']";
		return WaitForWebElementViaXpathLocator(locator);
	}

	public static boolean WaitForWebElementViaXpathLocator(String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			String text = GetTextFromElementViaXpathLocator(locator);
			if (!StringUtils.isEmpty(text)) {
				ConsoleWrite("Element " + text + " is visible!");
			} else {
				ConsoleWrite("Element " + locator + " is visible!");
			}
			return true;
		} catch (Exception e) {
			ConsoleWrite("Element with locator: " + locator + " is not present on the page!");
		}
		return false;
	}

	public static void ConsoleWrite(String message) {
		System.out.println(message);
	}

	public static String GetTextFromElementViaXpathLocatorID(String elementId) throws Exception {
		String locator = "//*[@id='" + elementId + "']";
		return GetTextFromElementViaXpathLocator(locator);
	}

	public static String GetTextFromElementViaXpathLocator(String locator) throws Exception {
		WebElement element = driver.findElement(By.xpath(locator));
		return GetTextFromElementViaElement(element);
	}

	public static String GetTextFromElementViaElement(WebElement element) {
		String text = element.getText();
		if (!StringUtils.isEmpty(text)) {
			return text;
		} else {
			return "";
		}
	}

	public static void ChangeLanguage(String lang) throws Exception {
		ConsoleWrite("Select language: " + lang);
		String actualLang = GetCurrentLanguage();
		if (actualLang.equals(lang)) {
			ConsoleWrite("This language is already selected.");
			return;
		}

		if (lang.equals("English")) {
			ClickOnElementViaElementXpath("//strong[text()='Eng']");
			ConsoleWrite("English language is selected.");
		}

		if (lang.equals("Serbian")) {
			ClickOnElementViaElementXpath("//strong[text()='Srb']");
			ConsoleWrite("English language is selected.");
		}
	}


	private static String GetCurrentLanguage() throws Exception {
		if (WaitForWebElementViaXpathLocator("//strong[text()='Srb']")) return "English";
		return "Serbian";
	}

	public static void WaitTime(int time) {
		try {
			Thread.sleep(1000 * (long) time);
		} catch (Exception e) {
			ConsoleWrite("Thread sleep failed.");
		}
	}

	public static void HoverOverElementViaXpathLocator(String locator) throws Exception {
		WaitForWebElementViaXpathLocator(locator);
		WebElement element = driver.findElement(By.xpath(locator));
		HoverOverElementViaElement(element);
	}

	public static void HoverOverElementViaElement(WebElement element) throws Exception {
		Actions action = new Actions(driver);
		WaitTime(1);
		action.moveToElement(element).perform();
		WaitTime(1);
	}

	public static void TypeTextViaElementId(String elementId, String value) throws Exception {
		String locator = "//*[@id='" + elementId + "']";
		TypeTextViaXpathLocator(locator, value);
	}

	public static void TypeTextViaXpathLocator(String locator, String value) throws Exception {
		AssertWebElementExistsViaXpathLocator(locator);
		WebElement element = driver.findElement(By.xpath(locator));
		ClearText(element);
		ConsoleWrite("Insert value: " + value + " into field with locator: " + locator);
		element.sendKeys(value);
	}

	public static void ClearText(WebElement element) {
		ConsoleWrite("Clear element with locator: " + element);
		element.clear();
	}
}

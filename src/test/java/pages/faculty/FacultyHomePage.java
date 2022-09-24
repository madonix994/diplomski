package pages.faculty;

import helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static steps.StepsHooks.driver;

public class FacultyHomePage extends BasePage {

	public static void NavigateToFacultyWebsite() throws Exception {
		driver.get("http://www.ftn.kg.ac.rs/");
		ClickOnElementViaElementID("cookieButton");
	}

	public static void ValidateHomePageElements() throws Exception {
		AssertWebElementExistsViaElementID("logo");
		AssertWebElementExistsViaElementID("header-title");
		AssertWebElementExistsViaElementID("box-search");
		AssertWebElementExistsViaElementID("carousel");
		AssertWebElementExistsViaElementID("footer-widgets");
		AssertWebElementExistsViaElementID("social-header");
		AssertWebElementExistsViaXpathLocator("//i[@class='fa fa-home']");
		AssertWebElementExistsViaXpathLocator("//li[@class='dropdown']/a");
		AssertWebElementExistsViaXpathLocator("//li[8]/a/strong");
		if (currentLanguage.equals("Serbian")) {
			AssertWebElementExistsViaXpathLocator("//li[@class='dropdown login']//a");
			AssertWebElementExistsViaXpathLocator("//*[@class='carousel-caption']");
			AssertWebElementExistsViaXpathLocator("//div[@id='newscontent']//div[2]");
			AssertWebElementExistsViaXpathLocator("//div[@id='newscontent']//div[3]");
			AssertWebElementExistsViaXpathLocator("//div[@id='newscontent']//div[4]");
			for (int i = 1; i < 5; i++) {
				AssertWebElementExistsViaXpathLocator("(//a[@data-toggle='tab'])[" + i + "]");
				AssertWebElementExistsViaXpathLocator("//*[@id='messages']/div[" + i + "]");
				AssertWebElementExistsViaXpathLocator("//*[@id='accordion']/div[" + i + "]/div/h4");
			}
		} else {
			AssertWebElementExistsViaXpathLocator("//*[@class='panel-heading']");
			AssertWebElementExistsViaElementID("aboutfak");
		}
	}

	public static void ValidateNavBarElementsOnSerbian() throws Exception {
		List<WebElement> navbarElements = driver.findElements(By.xpath("//li[@class='dropdown']/a"));
		int counter = 2;
		for (WebElement element : navbarElements) {
			HoverOverElementViaElement(element);
			for (int i = 1; i <= driver.findElements(By.xpath("//nav[@id='homebar']/div[1]/div[2]/ul[1]/li[" + counter + "]/ul[1]/li")).size(); i++) {
				AssertWebElementExistsViaXpathLocator("//nav[@id='homebar']/div[1]/div[2]/ul[1]/li[" + counter + "]/ul[1]/li[" + i + "]/a[1]");
			}
			counter++;
		}
	}

	public static void ValidateNavBarElementsOnEnglish() throws Exception {
		AssertWebElementExistsViaXpathLocator("//a[@href='eno-fakultetu']");
		AssertWebElementExistsViaXpathLocator("//a[@href='enstudije/osnovne']");
		AssertWebElementExistsViaXpathLocator("//a[@href='ennauka/naucne-delatnosti']");
		ClickOnElementViaElementXpath("//a[@href='eno-fakultetu']");
		for (int i = 1; i < 7; i++) {
			AssertWebElementExistsViaXpathLocator("//a[@href='eno-fakultetu']/../ul/li[" + i + "]/a");
		}
		ClickOnElementViaElementXpath("//a[@href='enstudije/osnovne']");
		for (int i = 1; i < 4; i++) {
			AssertWebElementExistsViaXpathLocator("//a[@href='enstudije/osnovne']/../ul/li[" + i + "]/a");
		}
		ClickOnElementViaElementXpath("//a[@href='ennauka/naucne-delatnosti']");
		for (int i = 1; i < 4; i++) {
			AssertWebElementExistsViaXpathLocator("//a[@href='ennauka/naucne-delatnosti']/../ul/li[" + i + "]/a");
		}
		AssertWebElementExistsViaXpathLocator("//a[contains(text(),'Location')]");
		AssertWebElementExistsViaXpathLocator("//a[contains(text(),'Contacts')]");
	}
}

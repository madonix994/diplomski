package pages.portal;

import helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static steps.StepsHooks.driver;

public class PortalHomePage extends BasePage {

	public static void NavigateToPortalWebsite() throws Exception {
		driver.get("https://portal.ftn.kg.ac.rs/student/pocetna");
		TypeTextViaElementId("username", "320/2015");
		TypeTextViaElementId("password", "kraljevo036");
		ClickOnElementViaElementID("btnSubmit");
		driver.get("https://portal.ftn.kg.ac.rs/student/pocetna");
	}

	public static void ValidatePortalHomePageElements() throws Exception {
		AssertWebElementExistsViaXpathLocator("//*[@class='text-center']/a");
		AssertWebElementExistsViaXpathLocator("//i[@class='md md-menu']");
		AssertWebElementExistsViaXpathLocator("//span[@class='name']");
		AssertWebElementExistsViaXpathLocator("//a[@data-toggle='dropdown']//b[1]");
		AssertWebElementExistsViaXpathLocator("//div[@class='profile-widget text-center']/div/font");
		AssertWebElementExistsViaXpathLocator("//div[@class='profile-widget text-center']/ul");
		AssertWebElementExistsViaXpathLocator("//div[@class='profile-widget text-center']/div/div");
		AssertWebElementExistsViaXpathLocator("//i[@class='fa fa-facebook']");
		AssertWebElementExistsViaXpathLocator("//i[@class='fa fa-twitter']");
		AssertWebElementExistsViaXpathLocator("//i[@class='fa fa-linkedin']");
		AssertWebElementExistsViaXpathLocator("//i[@class='fa fa-linkedin']");
		for (int i = 1; i <= 2; i++) {
			for (int j = 1; j <= driver.findElements(By.xpath("//div[" + i + "]/table[@id='example-paper']/tbody/tr")).size(); j++) {
				AssertWebElementExistsViaXpathLocator("//div[" + i + "]/table[@id='example-paper']/tbody/tr[" + j + "]/td[1]");
				AssertWebElementExistsViaXpathLocator("//div[" + i + "]/table[@id='example-paper']/tbody/tr[" + j + "]/td[2]");
			}
		}
	}

	public static void ValidateNavBarElements() throws Exception {
		int counter = 1;
		ClickOnElementViaElementXpath("//li[@class='has-sub'][1]/a/span[2]");
		List<WebElement> navbarElements = driver.findElements(By.xpath("//li[@class='has-sub']/a/span[1]"));
		for (WebElement navElement : navbarElements) {
			ClickOnElementViaWebElement(navElement);
			for (int i = 1; i <= driver.findElements(By.xpath("//li[@class='has-sub'][" + counter + "]/ul/li")).size(); i++) {
				AssertWebElementExistsViaXpathLocator("//li[@class='has-sub'][" + counter + "]/ul/li[" + i + "]");
			}
			counter++;
		}
		AssertWebElementExistsViaXpathLocator("//*[@id='sidebar-menu']/ul/li[4]/a/span");
		AssertWebElementExistsViaXpathLocator("//*[@id='sidebar-menu']/ul/li[10]/a/b/span");
		for (int i = 6; i <= 9; i++) {
			AssertWebElementExistsViaXpathLocator("//*[@id='sidebar-menu']/ul/li[" + i + "]/a/span");
		}
	}


	public static void NavigateToPortalPage(String pageURL) throws Exception {
		switch (pageURL) {
			case "Pocetna strana":
				ClickOnElementViaElementXpath("(//a[@href='/student/pocetna'])");
				AssertIfURLIsCorrect("/student/pocetna");
				break;
			case "Vesti":
				ClickOnElementViaElementXpath("//a[@href='/vesti']");
				AssertIfURLIsCorrect("/vesti");
				break;
			case "Osvojeni ESPB":
				ClickOnElementViaElementXpath("//a[@href='/student/espb']");
				AssertIfURLIsCorrect("/student/espb");
				break;
			case "Upisani semestri":
				ClickOnElementViaElementXpath("//a[@href='/student/upisani-semestri']");
				AssertIfURLIsCorrect("/student/upisani-semestri");
				break;
			case "Polozeni ispiti":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Испити ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Испити ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/ispiti/svi-ispiti']");
				AssertIfURLIsCorrect("/ispiti/svi-ispiti");
				break;
			case "Prijave ispita":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Испити ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Испити ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/ispiti/prijave']");
				AssertIfURLIsCorrect("/ispiti/prijave");
				break;
			case "Upisani predmeti":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Испити ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Испити ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/ispiti/upisani-predmeti']");
				AssertIfURLIsCorrect("/ispiti/upisani-predmeti");
				break;
			case "Teme zavrsnih radova":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Испити ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Испити ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/student/teme-zavrsnih-radova']");
				AssertIfURLIsCorrect("/student/teme-zavrsnih-radova");
				break;
			case "Prijave kolokvijuma":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Колоквијуми ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Колоквијуми ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/kolokvijum/prijavljeni']");
				AssertIfURLIsCorrect("/kolokvijum/prijavljeni");
				break;
			case "E-prijava":
				ClickOnElementViaElementXpath("//a[@href='/eprijava']//span[1]");
				AssertIfURLIsCorrect("/eprijava");
				break;
			case "Skolarina":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Финансије ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Финансије ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/finansije/skolarina']");
				AssertIfURLIsCorrect("/finansije/skolarina");
				break;
			case "Promene na racunu":
				if (!WaitForWebElementViaXpathLocator("//span[text()=' Финансије ']/../../ul[contains(@style,'display: block')]")) {
					ClickOnElementViaElementXpath("//span[text()=' Финансије ']");
				}
				ClickOnElementViaElementXpath("//a[@href='/eprijava/racun']");
				AssertIfURLIsCorrect("/eprijava/racun");
				break;
			case "Raspored ispita":
				ClickOnElementViaElementXpath("//a[@href='/raspored/raspored-ispita']//span[1]");
				AssertIfURLIsCorrect("/raspored/raspored-ispita");
				break;
			case "Raspored casova":
				ClickOnElementViaElementXpath("//a[@href='/raspored/raspored-casova']//span[1]");
				AssertIfURLIsCorrect("/raspored/raspored-casova");
				break;
			case "Pregled konsultacija":
				ClickOnElementViaElementXpath("//a[@href='/raspored/konsultacije']//span[1]");
				AssertIfURLIsCorrect("/raspored/konsultacije");
				break;
			case "Ponuda za upis":
				ClickOnElementViaElementXpath("//a[@href='/student/ponuda-za-upis']//span[1]");
				AssertIfURLIsCorrect("/student/ponuda-za-upis");
				break;
			case "Popunjavanje uplatnice":
				ClickOnElementViaElementXpath("//a[@href='/eprijava/postupak-prijave']//span[1]");
				AssertIfURLIsCorrect("/eprijava/postupak-prijave");
				break;
			default:
				throw new Exception("Page with URl: " + pageURL + " is not configured!");
		}
		ValidatePageElements(pageURL);
	}

	private static void ValidatePageElements(String pageURL) throws Exception {
		switch (pageURL) {
			case "Pocetna strana":
				break;
			case "Vesti":
				AssertWebElementExistsViaXpathLocator("//table");
				break;
			case "Osvojeni ESPB":
				AssertWebElementExistsViaXpathLocator("(//div[@class='panel-heading']//font)[2]");
				break;
			case "Upisani semestri":
				AssertWebElementExistsViaXpathLocator("(//div[@class='panel-heading']//font)[2]");
				AssertWebElementExistsViaXpathLocator("//table");
				break;
			case "Polozeni ispiti":
				AssertWebElementExistsViaXpathLocator("(//div[@class='panel-heading']//font)[2]");
				for (int i = 1; i <= 4; i++) {
					AssertWebElementExistsViaXpathLocator("//label[@for='inlineRadio" + i + "']");
				}
				AssertWebElementExistsViaXpathLocator("//table");
				break;
			case "Prijave ispita":
			case "Prijave kolokvijuma":
				AssertWebElementExistsViaXpathLocator("//div[@class='alert alert-info'][1]//font[1]");
				AssertWebElementExistsViaXpathLocator("//div[@class='alert alert-info'][2]//font[1]");
				break;
			case "Upisani predmeti":
				AssertWebElementExistsViaXpathLocator("(//div[@class='panel-heading']//font)[2]");
				AssertWebElementExistsViaXpathLocator("(//div[@class='panel-heading']//font)[4]");
				break;
			case "Teme zavrsnih radova":
				AssertWebElementExistsViaXpathLocator("//font[text()='Нема слободних тема за Ваш ниво студија!']");
				break;
			case "E-prijava":
				AssertWebElementExistsViaXpathLocator("//span[@class='text-dark']");
				AssertWebElementExistsViaXpathLocator("//div[@class='panel-heading']");
				AssertWebElementExistsViaXpathLocator("//div/font[contains(text(),'Начин попуњавања уплатнице за пријаву испита')]");
				break;
			case "Skolarina":
				AssertWebElementExistsViaXpathLocator("//b[text()='2020/2021']");
				AssertWebElementExistsViaXpathLocator("//b[text()='2020/2021']");
				break;
			case "Promene na racunu":
				AssertWebElementExistsViaXpathLocator("//span[@class='m-r-10']");
				AssertWebElementExistsViaXpathLocator("//div[@class='alert alert-warning']//span[1]");
				AssertWebElementExistsViaXpathLocator("//div[@class='alert alert-warning']//span[1]");
				AssertWebElementExistsViaXpathLocator("(//div[@class='panel-heading']//font)[2]");
				AssertWebElementExistsViaXpathLocator("//table");
				break;
			case "Raspored ispita":
			case "Raspored casova":
				AssertWebElementExistsViaXpathLocator("//div[@class='alert alert-info'][1]//font[1]");
				break;
			case "Pregled konsultacija":
				break;
			case "Ponuda za upis":
				AssertWebElementExistsViaXpathLocator("//div[@class='alert alert-info']");
				break;
			case "Popunjavanje uplatnice":
				AssertWebElementExistsViaXpathLocator("//*[@id='wrapper']/div[3]/div/div/div[3]/div/table/tbody/tr/td[1]/div");
				AssertWebElementExistsViaXpathLocator("//*[@id='wrapper']/div[3]/div/div/div[5]/div/table/tbody/tr/td[1]/div");
				break;
			default:
				throw new Exception("Page with URl: " + pageURL + " is not configured!");
		}
	}

	public static void AssertIfURLIsCorrect(String pageURL) throws Exception {
		WaitTime(1);
		String actualURL = driver.getCurrentUrl().trim().toLowerCase();
		if (!actualURL.contains(pageURL.toLowerCase())) {
			throw new Exception("Expected URL is: " + pageURL + "! Actual URL is: " + actualURL);
		} else {
			ConsoleWrite("Expected URL is: " + pageURL + " which is correct.");
		}
	}

	public static void DownloadPDF() throws Exception {
		ClickOnElementViaElementXpath("//a[@class='stampajUplatnicu']//img[1]");
		ClickOnElementViaElementXpath("//a[@class='stampajUplatnicuSkolarina']//img[1]");
	}

	public static void ValidateNumberOfExams(int numberOfExams) throws Exception {
		String actualValue = GetTextFromElementViaXpathLocator("(//div[@class='panel-heading']//font)[2]");
		if (!actualValue.contains(String.valueOf(numberOfExams))) {
			throw new Exception("Expected number of exams is: " + numberOfExams + "! Actual value is: " + actualValue);
		}
		ConsoleWrite("Expected number of exams is correct: " + numberOfExams);
	}

	public static void NavigateToExamsWithStatus(String status) throws Exception {
		switch (status) {
			case "Passed":
				ClickOnElementViaElementXpath("//label[@for='inlineRadio2']");
				break;
			case "Recognized":
				ClickOnElementViaElementXpath("//label[@for='inlineRadio3']");
				break;
			case "Transferred":
				ClickOnElementViaElementXpath("//label[@for='inlineRadio4']");
				break;
			default:
				throw new Exception("There are no exams with status: " + status);
		}
	}
}

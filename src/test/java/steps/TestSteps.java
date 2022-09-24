package steps;

import helpers.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.faculty.FacultyHomePage.NavigateToFacultyWebsite;
import static pages.faculty.FacultyHomePage.ValidateHomePageElements;
import static pages.faculty.FacultyHomePage.ValidateNavBarElementsOnEnglish;
import static pages.faculty.FacultyHomePage.ValidateNavBarElementsOnSerbian;
import static pages.portal.PortalHomePage.DownloadPDF;
import static pages.portal.PortalHomePage.NavigateToExamsWithStatus;
import static pages.portal.PortalHomePage.NavigateToPortalPage;
import static pages.portal.PortalHomePage.NavigateToPortalWebsite;
import static pages.portal.PortalHomePage.ValidateNavBarElements;
import static pages.portal.PortalHomePage.ValidateNumberOfExams;
import static pages.portal.PortalHomePage.ValidatePortalHomePageElements;


public class TestSteps extends BasePage {

	@Given("^User navigates to Faculty website$")
	public void userNavigatesToFacultyWebsite() throws Exception {
		ConsoleWrite("User navigates and validates page: http://www.ftn.kg.ac.rs/");
		NavigateToFacultyWebsite();
		ConsoleWrite("User is navigated to page: http://www.ftn.kg.ac.rs/");
	}

	@Then("^All elements are present on the page$")
	public void allElementsArePresentOnThePage() throws Exception {
		ConsoleWrite("Validate if all elements are present on the Home page.");
		ValidateHomePageElements();
		ConsoleWrite("All elements are present on the Home page.");
	}

	@When("^User selects (.*) language$")
	public void userSelectsLanguage(String lang) throws Exception {
		ChangeLanguage(lang);
		currentLanguage = lang;
	}

	@And("^All navbar elements are present$")
	public void allNavbarElementsArePresent() throws Exception {
		if (currentLanguage.equals("Serbian")) {
			ValidateNavBarElementsOnSerbian();
		} else {
			ValidateNavBarElementsOnEnglish();
		}
	}

	@Given("^User navigates to Student Portal website$")
	public void userNavigatesToStudentPortalWebsite() throws Exception {
		ConsoleWrite("User navigates and validates page: https://portal.ftn.kg.ac.rs/student/pocetna");
		NavigateToPortalWebsite();
		ConsoleWrite("User is navigated to page: https://portal.ftn.kg.ac.rs/student/pocetna");
	}

	@Then("^All elements are present on the Portal page$")
	public void allElementsArePresentOnThePortalPage() throws Exception {
		ConsoleWrite("Validate if all elements are present on the Portal Home page.");
		ValidatePortalHomePageElements();
		ConsoleWrite("All elements are present on the Portal Home page.");
	}

	@And("^All navbar elements are present on Portal page$")
	public void allNavbarElementsArePresentOnPortalPage() throws Exception {
		ConsoleWrite("Validate if all nav bar elements are present.");
		ValidateNavBarElements();
		ConsoleWrite("All nav bar elements are present.");
	}

	@Then("^User navigates and validates page (.*)$")
	public void userNavigatesToPage(String pageURL) throws Exception {
		ConsoleWrite("Navigate user to page: " + pageURL);
		NavigateToPortalPage(pageURL);
		ConsoleWrite("User is navigated to page: " + pageURL);
	}

	@Then("^User downloads both PDF files$")
	public void userDownloadsBothPDFFiles() throws Exception {
		ConsoleWrite("User downloads two pdf files.");
		DownloadPDF();
		ConsoleWrite("PDFS are downloaded.");
	}

	@Then("^Expected number of all exams is (\\d+)$")
	public void expectedNumberOfAllExamsIs(int numberOfExams) throws Exception {
		ConsoleWrite("Validate number of all exams.");
		ValidateNumberOfExams(numberOfExams);
	}

	@And("^User navigates to (.*) exams$")
	public void userNavigatesToPassedExams(String status) throws Exception {
		ConsoleWrite("User navigates to "+status+" exams.");
		NavigateToExamsWithStatus(status);
	}
}
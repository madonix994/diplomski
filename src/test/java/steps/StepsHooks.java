package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class StepsHooks {

	public static String featureName = "";
	public static String scenarioName = "";
	public static int scenarioCounter = 0;
	public static WebDriver driver;

	/**
	 * Method that runs before each scenario
	 *
	 * @param scenario
	 * @throws IOException
	 */
	@Before
	public void beforeScenario(Scenario scenario) {
		scenarioName = scenario.getName();
		String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
		featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
		scenarioCounter++;
		System.out.println("\n ------------------ Scenario: " + scenario.getName() + " was started ------------------\n");
		System.setProperty("webdriver.chrome.driver", "D:\\iCore\\trunk\\ToolsExternal\\ChromeDriver\\chromedriver105.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--incognito");
		driver = new ChromeDriver(chromeOptions);
	}

	/**
	 * Method that runs after each scenario
	 */
	@After
	public void afterScenario(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed it in the report.
			scenario.attach(screenshot, "image/png", "Screenshot");
		}
		driver.quit();
		System.out.println("\n -------- Scenario: " + scenario.getName() + " is completed. Status: " + scenario.getStatus().name().toUpperCase() + " --------\n\n");
//		Reporter.features.add()
	}
}

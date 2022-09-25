import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/resources",
		glue = {"steps"},
		plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
		monochrome = true
)

public class TestRunner {
	public static void main(String[] args) {
	}
}
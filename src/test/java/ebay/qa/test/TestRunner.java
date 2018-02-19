package ebay.qa.test;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
plugin = {"pretty", "html:target/cucumber-report-html", "json:build/cucumber.json"},
features = {"classpath:features"},
glue= {"ebay.qa.test"}
//tags = {"@001"}
)

public class TestRunner {
	
}

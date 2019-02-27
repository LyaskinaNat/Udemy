package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "src/test/resources/features/", glue = "stepdefs", tags = {"@chrome_br, @safari_br, @firefox_br"})
public class RunCucumberTest {
}

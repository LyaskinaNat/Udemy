package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",

        },
        features = "src/test/java/resources/features",
        glue = "src/main/java/stepDefinitions",
        tags = {})


public class MainRunner {
}

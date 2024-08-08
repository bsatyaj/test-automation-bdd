package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"utils","stepdefs"},
        plugin = {"pretty", "html:target/cucumber-report/report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

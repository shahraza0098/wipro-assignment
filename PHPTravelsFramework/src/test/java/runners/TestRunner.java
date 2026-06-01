package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Question 6 – Parallel Execution Framework
 * Question 10 – Tags Execution
 *
 * AbstractTestNGCucumberTests integrates Cucumber with TestNG.
 * parallel=true in @DataProvider enables parallel scenario execution.
 */
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    tags = "@Smoke or @Regression",
    plugin = {
        "pretty",
        "html:reports/cucumber-html-report.html",
        "json:reports/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true,
    dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    /**
     * Question 6 – Parallel Execution
     * parallel=true enables running scenarios concurrently.
     * Thread count is controlled in testng.xml (thread-count="5").
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

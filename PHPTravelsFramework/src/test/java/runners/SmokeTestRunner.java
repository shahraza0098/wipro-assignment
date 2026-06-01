package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Smoke Test Runner – runs only @Smoke tagged scenarios.
 * Question 10 – Tags Execution
 */
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    tags = "@Smoke",
    plugin = {
        "pretty",
        "html:reports/smoke-report.html",
        "json:reports/smoke.json"
    },
    monochrome = true
)
public class SmokeTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

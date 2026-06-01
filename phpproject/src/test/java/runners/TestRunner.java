//
//
//
//
//
//
//package runners;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//
//@SuppressWarnings("deprecation")
//@CucumberOptions(
//features="src/test/resources/features",
//glue={"StepDefination", "helperutils"},
//tags="@Regression",
//plugin={
//		 "pretty",
//	        "html: target/htmlreport/report.html",
//	        "json: target/jsonreport/report.json",
//	        "junit:target/junitreport/report.xml"
//}
//
//)
//
//public class TestRunner {
//
//}








package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.*;

@CucumberOptions(
        features =
        "src/test/resources/features",

        glue = {
                "stepdefinitions",
                "hooks"
        },

        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },

        tags = "@Smoke or @Regression"
)
public class TestRunner
extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}
//package StepDefination;
//
//import io.cucumber.junit.CucumberOptions;
//
//@SuppressWarnings("deprecation")
//@CucumberOptions(features=)
//public class TestRunner {
//
//}









package StepDefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@SuppressWarnings("deprecation")
@CucumberOptions(
features="src/test/resources/features/TutorialNinja.feature",
glue={"StepDefination", "helperutils"},
tags="@Regression",
plugin={
		 "pretty",
	        "html: target/htmlreport/report.html",
	        "json: target/jsonreport/report.json",
	        "junit:target/junitreport/report.xml"
}

)

public class TestRunner {

}
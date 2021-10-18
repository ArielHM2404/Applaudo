package Runners.AutomationPractice;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = { "src/test/resources/FeaturesFiles/AutomationPractice/" },
        glue = {  "StepDefinitions" },
        tags = "@ShoppingCart",
        monochrome = true,
        plugin = {
                "json:target/cucumber-reports/cucumber.json", "pretty",
                "html:target/cucumber-html-report/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)


public class AutomationPracticeRunner extends AbstractTestNGCucumberTests{
}

package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures/CarValuation.feature"},
        glue = {"stepdefinitions", "AppHooks"},
        plugin = { "usage" ,
                "json:target/cucumber-reports/Cucumber.json" ,
                "junit:target/cucumber-reports/Cucumber.xml",
        },
        monochrome = true

)

public class MyTestRunner {


}

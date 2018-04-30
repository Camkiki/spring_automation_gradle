package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by tolaf on 29/04/2018.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/")
public class TestRunner {
}



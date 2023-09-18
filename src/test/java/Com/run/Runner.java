package Com.run;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/FeaturesFile/LoginSteps.feature","src/test/resources/FeaturesFile/Customers.feature"}
		,glue = {"StepDefinition"}
		,monochrome =false
		,dryRun = false
		,tags = {"@sanity,@regression"}
		)

public class Runner  
{
 
}

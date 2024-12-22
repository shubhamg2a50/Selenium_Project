package testRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
        features = "src\\test\\resources\\Feature\\TitleValidation.feature",       // Corrected path
        glue = "stepDefinitions",
        dryRun = false, // Set to false for actual execution
        plugin = {
            "pretty",
            "html:target/cucumber-reports/cucumber.html", 
            "json:target/cucumber-reports/cucumber.json"  
        },
        monochrome = true,
        publish = true 
        
)
public class MyRunner extends AbstractTestNGCucumberTests {
	
	
}
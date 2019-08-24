package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/features/ForecastFeature.feature"},
	glue={"step_definitions"},
    tags= {"@weather,@Forecast,@Round"},
    format= {"pretty","html:target/ForeCast Run Reports"},
    monochrome=true)

public class WeatherForecastTestRunner {

}

package karate.features.greetings;

import com.intuit.karate.junit5.Karate;
import cucumber.api.CucumberOptions;


@CucumberOptions(features = "classpath:GreetingsGetAPI",monochrome = true,plugin = ("json:build/karate-reports/CucumberTestReport.json"))
public class GreetingsRunner {

    @Karate.Test
    Karate getAPITest(){
        return  Karate.run("GreetingsGetAPI").relativeTo(getClass());
    }
}

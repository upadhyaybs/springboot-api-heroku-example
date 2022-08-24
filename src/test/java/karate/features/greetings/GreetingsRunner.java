package karate.features.greetings;

import com.intuit.karate.junit5.Karate;



public class GreetingsRunner {


    @Karate.Test
    Karate getAPITest(){
        System.out.println("##############"+System.getProperty("test.profile")+"###########");
        return  Karate.run("GreetingsGetAPI").relativeTo(getClass());
    }

}

package com.codify.demo.karate;

import com.intuit.karate.junit5.Karate;

public class GreetingsRunner {

    @Karate.Test
    Karate getAPITest(){
        return  Karate.run("GreetingsGetAPI").relativeTo(getClass());
    }
}

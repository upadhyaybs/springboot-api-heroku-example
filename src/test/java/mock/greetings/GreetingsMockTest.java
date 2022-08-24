package karate.features.greetings;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.core.MockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;



import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GreetingsMockTest {

    static MockServer server;


    @BeforeAll
    public static void beforeClass() {
        server = MockServer
                .feature("classpath:mock/greetings/greetings-mock.feature")
                .arg("demoServerPort", null)
                .http(0).build();

    }


    @Test
    public void testMock() {
        System.setProperty("karate.env", "mock");
        Results results = Runner.path("classpath:karate/features/greetings/GreetingsGetAPI.feature")
                //.systemProperty("karate.env", "mock")
                .karateEnv("mock")
               .systemProperty("mock.greetings.url", "http://localhost:" + server.getPort() )
               // .clientFactory(new MockSpringMvcServlet())
                .parallel(1);
        assertTrue( results.getFailCount() == 0,results.getErrorMessages());
    }
}

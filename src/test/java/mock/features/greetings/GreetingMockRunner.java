package mock.features.greetings;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.core.MockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GreetingMockRunner {

    static MockServer server;

    @BeforeAll
    public static void beforeClass() {
        server = MockServer
                .feature("classpath:mock/features/greetings/greetingsAPI-mock.feature")
                .arg("demoServerPort", null)
                .http(0).build();
    }

    @Test
    public void testMock() {
        Results results = Runner.path("classpath:mock/features/greetings/greetingsAPI.feature")
                .karateEnv("mock")
                .systemProperty("mock.greetings.url", "http://localhost:" + server.getPort() )
                .parallel(1);
        assertTrue(results.getFailCount()==0, results.getErrorMessages());
    }
}

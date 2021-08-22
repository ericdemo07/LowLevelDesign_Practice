import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClientCallTest {

    private static Java8HttpClient java8HttpClient;

    @BeforeAll
    static void setup() {
        java8HttpClient = new Java8HttpClient();
    }

    @Test
    public void testClientApiCall() {
        APODModel o = java8HttpClient.makeClientApiCall("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        System.out.println(o);
    }
}

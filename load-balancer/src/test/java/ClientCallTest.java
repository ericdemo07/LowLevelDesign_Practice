import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ClientCallTest {
    private static Java8HttpClient  java8HttpClient;
    private static Java11HttpClient java11HttpClient;

    @BeforeAll
    static void setup() {
        java8HttpClient = new Java8HttpClient();
        java11HttpClient = new Java11HttpClient();
    }

    @Test
    public void testClientApiCallJava8() {
        APODModel apodModel = java8HttpClient.makeClientApiCall("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

        Assertions.assertTrue("image".equals(apodModel.mediaType));
    }

    @Test
    public void testSyncClientApiCallJava11() {
        APODModel apodModel = null;
        try {
            apodModel = java11HttpClient.makeClientApiCallSync("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue("image".equals(apodModel.mediaType));
    }

    @Test
    public void testAsyncClientApiCallJava11() {
        APODModel apodModel = null;
        try {
            apodModel = java11HttpClient.makeClientApiCallASync("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        Assertions.assertTrue("image".equals(apodModel.mediaType));
    }
}

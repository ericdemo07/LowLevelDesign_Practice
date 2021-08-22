import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Java8HttpClient {

    private static final ObjectMapper mapper = new ObjectMapper();

    public APODModel makeClientApiCall(String urlAsString) {
        APODModel apodModel = null;
        try {
            URL url = createUrl(urlAsString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");

            InputStream responseStream = connection.getInputStream();

            APODModel apod = mapper.readValue(responseStream, APODModel.class);

            return apod;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return apodModel;
    }

    private URL createUrl(String urlAsString) throws MalformedURLException {
        return new URL(urlAsString);
    }
}

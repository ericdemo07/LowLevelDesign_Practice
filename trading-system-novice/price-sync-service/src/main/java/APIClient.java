import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class APIClient {

    private final ObjectMapper        mapper;
    private final CloseableHttpClient client;

    private final String   VS_CURRENCIES;
    private final String[] COIN_IDS;
    private final HttpGet  REQUEST;

    private final RedisClient redisClient;

    public APIClient(RedisClient redisClient, String[] coinIds) throws URISyntaxException {
        this.mapper = new ObjectMapper();
        this.client = HttpClients.createDefault();
        this.VS_CURRENCIES = "usd";
        this.COIN_IDS = coinIds;

        String host = "http://api.coingecko.com/api/v3/simple/price";

        URI uri = new URIBuilder(host).addParameter("ids", String.join(",", COIN_IDS))
                                      .addParameter("vs_currencies", VS_CURRENCIES)
                                      .build();

        this.REQUEST = new HttpGet(uri);

        this.redisClient = redisClient;
    }


    public void refreshCache() throws IOException {
        Map<String, Map<String, Double>> response = getPrice();
        for (String val : COIN_IDS) {
            Map<String, Double> map = response.get(val);

            if (map != null && map.get(VS_CURRENCIES) != null) {
                redisClient.setCrypto(val, map.get(VS_CURRENCIES));
            }
        }

        System.out.println("\ndata refreshed successfully");
    }

    private Map<String, Map<String, Double>> getPrice() throws IOException {
        Map<String, Map<String, Double>> response = client.execute(REQUEST, httpResponse ->
                mapper.readValue(httpResponse.getEntity().getContent(),
                                 new TypeReference<HashMap<String, Map<String, Double>>>() {
                                 }));

        return response;
    }
}

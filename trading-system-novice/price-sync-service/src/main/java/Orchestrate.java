import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Orchestrate {

    private final RedisClient redisClient;
    private final APIClient   apiClient;

    private final String[] COIN_IDS;

    public Orchestrate() throws URISyntaxException {
        this.COIN_IDS = new String[]{"bitcoin", "ethereum", "bitcoin-cash"};
        this.redisClient = new RedisClient();
        this.apiClient = new APIClient(this.redisClient, this.COIN_IDS);
    }

    
    public static void main(String... args) throws URISyntaxException {
        Orchestrate orchestrate = new Orchestrate();
        orchestrate.scheduleRun();
    }

    private void scheduleRun() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::process, 3, 10, TimeUnit.SECONDS);
    }

    private void process() {
        try {
            apiClient.refreshCache();
            printLatestPrices();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void printLatestPrices() {
        for (String val : COIN_IDS) {
            System.out.println(val + " : " + redisClient.getValue(val));
        }
    }
}

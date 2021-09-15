import redis.clients.jedis.Jedis;

public class RedisClient {

    private final Jedis jedis;

    public RedisClient() {
        this.jedis = new Jedis();
    }

    public void setCrypto(String key, double value) {
        jedis.set(key, String.valueOf(value));
    }

    public double getValue(String key) {
        String value = jedis.get(key);
        return Double.valueOf(value);
    }
}

package redis;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import utils.PropertiesKey;
import utils.PropertiesUtil;

import java.util.HashMap;


/**
 * Create a setup to the redis cluster
 */
public class Redis {

    private Jedis jedis;
    private Gson gson = new Gson();

    /**
     * Get the host and port from a properties file and creates a Jedis object
     */
    public Redis() {
        final String host = PropertiesUtil.getProperties(PropertiesKey.REDIS_HOST);
        final String stringPort = PropertiesUtil.getProperties(PropertiesKey.REDIS_PORT);

        final int port = stringPort.isEmpty() ? 6379 : Integer.parseInt(stringPort);

        this.jedis = new Jedis(host, port);
    }


    public <T, U> void importJson(HashMap<T, U> jsonMap) {
        jsonMap.forEach((key, data) -> jedis.set(key.toString(), gson.toJson(data)));
    }

}

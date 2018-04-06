package main;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.Redis;
import utils.PropertiesKey;
import utils.PropertiesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainApp {
    public static void main(String[] args) {
        final Redis redis = new Redis();
        final Gson gson = new Gson();
        final Logger logger = LogManager.getLogger("Main Logger");

        try {
            File jsonFile = new File(Objects.requireNonNull(PropertiesUtil.getProperties(PropertiesKey.JSON_FILE)));
            Reader reader = new FileReader(jsonFile);

            // creates a type token to use in the json serialization
            final TypeToken<HashMap<String, Map>> token = new TypeToken<HashMap<String, Map>>() {
            };

            redis.importJson(gson.fromJson(reader, token.getType()));

        } catch (NullPointerException e) {
            logger.info("Please inform the path to the json file that you want to import in the app.properties file.");
            logger.info("You can use the key: json.path=");
            logger.info("Example: json.path=myjson.json");
            System.exit(0);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            System.exit(0);
        }

    }
}

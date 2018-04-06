### Redis Json Importer ###
Imports any json file to a redis cluster


#### How to use ####

First create a properties file with the name: "app.properties" and place it in the same folder where you are going to execute the importer. In this file you can inform the redis host/port and the location of the json file. Example:

  ```
    redis.host=localhost
    redis.port=6379
    json.path=somejson.json
    
   ```
   

package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * DataReader utility handles parsing external JSON files to drive
 * test execution with dynamic test data datasets.
 */
public class dataReader {

    // Target runtime class variables holding extracted test data fields
    public String UserName;
    public String Password;
    public String firstName;
    public String lastName;
    public String postalCode;

    // Reads the external JSON target file and maps individual keys onto class properties
    public void reader() throws IOException, ParseException {
        String path = System.getProperty("user.dir") + "/src/test/java/data/userData.json";
        File srcFile = new File(path);

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));

        // Iterate through the JSON array to extract object properties dynamically
        for (Object yobject : jArray) {
            JSONObject person = (JSONObject) yobject;

            UserName   = (String) person.get("username");
            Password   = (String) person.get("password");
            firstName  = (String) person.get("firstName");
            lastName   = (String) person.get("lastName");
            postalCode = (String) person.get("postalCode");
        }
    }
}
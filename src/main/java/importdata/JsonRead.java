package importdata;

import com.sun.deploy.util.ArrayUtil;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonRead {
    private String file;

    public JsonRead(String file) {
        this.file = file;
    }

    public void read() {
        JSONObject obj = new JSONObject(file);


        JSONArray names = (JSONArray) obj.get("ballotResult");

        Map<String, Integer> wyn = new HashMap<>();
        String p1;
        Integer i1;
        for (int i=0;i<names.length();i++) {
            p1 = names.getJSONObject(i).getString("name");
            i1 = names.getJSONObject(i).getInt("votes");
            wyn.put(p1, i1);
        }

        System.out.println(Arrays.asList(wyn));
    }

}

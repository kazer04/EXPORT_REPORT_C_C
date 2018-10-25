/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkits.web;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */
public class json {

    public String Build() {
        JSONObject json = new JSONObject();
        JSONArray arrayObj = new JSONArray();
        json.put("ID", "7");
        json.put("NAME", "KAZER04");
        json.put("POSITION", "KING OF POP");
        json.put("AMBITION", "DOMINE THE WORLD");
        //arrayObj.put(json);
        arrayObj.put(json);
        String output = json.toString();
       // System.out.println(output);
        String result = "({\"total\":\"5\",\"results\":"+arrayObj.toString()+"})";
        return result;
       // System.out.println("({\"total\":\"5\",\"results\":"+arrayObj.toString()+"})");

    }
}

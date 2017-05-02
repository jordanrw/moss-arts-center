package com.mossartscenter.mossartscenterpatrons;

import android.app.Activity;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by sudowoodo on 4/21/17.
 */

public class JSONParser extends Activity {
    JSONObject jsonObject;

    String jsonStringToParse;
    Context mContext;

    public JSONParser(Context context, String jsonFile) {

        mContext = context;
        jsonStringToParse = loadJSONFromAsset(mContext, jsonFile);
        try {
            jsonObject = new JSONObject(jsonStringToParse);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getPerson(String patron) {

        try {
            JSONObject patronID = jsonObject.getJSONObject(patron);

            return patronID.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ""; // Default case
    }

    public String getUsername(String patron) {

        try {
            JSONObject patronID = jsonObject.getJSONObject(patron);
            return patronID.getString("username");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return ""; // Default case
    }

    public String getEmail(String patron) {

        try {
            JSONObject patronID = jsonObject.getJSONObject(patron);
            return patronID.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getAge(String patron) {

        try {
            JSONObject patronID = jsonObject.getJSONObject(patron);
            return patronID.getString("age");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public boolean isStudent(String patron) {

        try {
            JSONObject patronID = jsonObject.getJSONObject(patron);
            return patronID.getBoolean("student");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getPassword(String patron) {

        try {
            JSONObject patronID = jsonObject.getJSONObject(patron);
            return patronID.getString("password");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public HashMap getPurchased(String patron) {

        HashMap<String, String> purchases = new HashMap<>();

        JSONArray purchasedArray = null;
        try {

            JSONObject patronID = jsonObject.getJSONObject(patron);
            purchasedArray = patronID.getJSONArray("purchased");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Loop through all of the indices in the returned array
        for (int i = 0; i < purchasedArray.length(); i++) {
            try {
                JSONObject p = purchasedArray.getJSONObject(i);
                String title = p.getString("title");
                String date = p.getString("date");
                purchases.put("title", title);
                purchases.put("date", date);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return purchases;
    }

    public HashMap getHistory(String patron) {

        HashMap<String, String> history = new HashMap<>();

        JSONArray historyArray = null;
        try {

            JSONObject patronID = jsonObject.getJSONObject(patron);
            historyArray = patronID.getJSONArray("history");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Loop through all of the indices in the returned array
        for (int i = 0; i < historyArray.length(); i++) {
            try {
                JSONObject p = historyArray.getJSONObject(i);
                String title = p.getString("title");
                String date = p.getString("date");
                history.put("title" + i, title);
                history.put("date" + i, date);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return history;
    }


    /**
     * Open the JSON file for parsing
     */
    public String loadJSONFromAsset(Context context, String jsonFile) {
        String json = null;
        try {

            InputStream is = context.getAssets().open(jsonFile + ".json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

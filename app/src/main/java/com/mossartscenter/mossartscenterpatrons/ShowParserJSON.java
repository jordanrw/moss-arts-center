package com.mossartscenter.mossartscenterpatrons;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sudowoodo on 4/27/17.
 */

public class ShowParserJSON {


    JSONObject jsonObject;

    String jsonStringToParse;
    Context mContext;

    public ShowParserJSON(Context context, String jsonFile) {

        mContext = context;
        jsonStringToParse = loadJSONFromAsset(mContext, jsonFile);
        try {
            jsonObject = new JSONObject(jsonStringToParse);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public String getTitle(String targetJSON) {

        try {
            JSONObject show = jsonObject.getJSONObject(targetJSON);
            return show.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getDate(String targetJSON) {

        try {
            JSONObject show = jsonObject.getJSONObject(targetJSON);
            return show.getString("date");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getLocation(String targetJSON) {

        try {
            JSONObject show = jsonObject.getJSONObject(targetJSON);
            return show.getString("location");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getPrice(String targetJSON) {

        try {
            JSONObject show = jsonObject.getJSONObject(targetJSON);
            return show.getString("price");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getDescription(String targetJSON) {

        try {
            JSONObject show = jsonObject.getJSONObject(targetJSON);
            return show.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getCategory(String targetJSON) {

        try {
            JSONObject show = jsonObject.getJSONObject(targetJSON);
            return show.getString("category");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
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

package com.mossartscenter.mossartscenterpatrons;

/**
 * Created by AlexBrothers on 4/30/17.
 */

public class Show {

    private String title;
    private String date;

    public Show(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

}

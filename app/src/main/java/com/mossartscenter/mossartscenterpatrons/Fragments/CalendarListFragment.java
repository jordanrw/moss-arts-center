package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.mossartscenter.mossartscenterpatrons.R;
import com.mossartscenter.mossartscenterpatrons.ShowParserJSON;

import java.util.ArrayList;

/**
 * Created by Jordan on 4/23/17.
 */

public class CalendarListFragment extends ListFragment {

    ListView listView;
    ArrayList<String> dates;
    ArrayList<String> titles;
    ShowParserJSON showParserJSON;
    ArrayList<String> shows;
    MySimpleArrayAdapter mySimpleArrayAdapter;

    public CalendarListFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        showParserJSON = new ShowParserJSON(getContext(), "showinfo");
        dates = new ArrayList<String>();
        titles = new ArrayList<String>();
        shows = new ArrayList<String>();
        shows.add("RoanokeSymphonyOrchestra");
        shows.add("Belonging");
        shows.add("KidKoala");
        shows.add("SouthwestVirginiaBallet");
        shows.add("SecretAgent23Skidoo");
        shows.add("StuartPimslerDanceandTheater");
        shows.add("NewYorkGilbertandSullivanPlayers");
        shows.add("WhatBends");
        for (int i = 0; i < 8; i++) {
            dates.add(showParserJSON.getDate(shows.get(i)));
            titles.add(showParserJSON.getTitle(shows.get(i)));
        }
        mySimpleArrayAdapter = new MySimpleArrayAdapter(getContext(), titles, dates, null, CalendarListFragment.this, 1);
        listView = (ListView) view.findViewById(android.R.id.list);
        listView.setAdapter(mySimpleArrayAdapter);
        listView.setItemsCanFocus(true);
        Toast.makeText(getActivity(), "Now Showing: 2016 - 2017 Season",
                Toast.LENGTH_LONG).show();
        return view;


    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

    }
}

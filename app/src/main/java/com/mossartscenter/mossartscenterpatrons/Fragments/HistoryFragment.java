package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.app.ListActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.JSONParser;
import com.mossartscenter.mossartscenterpatrons.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jordan on 4/22/17.
 */

public class HistoryFragment extends ListFragment implements View.OnClickListener{
    TextView label;
    JSONParser jsonParser;
    ListView listView;
    ArrayAdapter<String> adapter;
    HashMap<String, String> history;
    ArrayList<String> listItems;
    MySimpleArrayAdapter simpleArrayAdapter;
    ArrayList<String> dateItems;

    public void HistoryFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        listItems = new ArrayList<>();
        dateItems = new ArrayList<>();
        jsonParser = new JSONParser(getContext(), "userprofiles");
        history = new HashMap();
        listView = (ListView) view.findViewById(android.R.id.list);
        history = jsonParser.getHistory("Patron1");
        for (int i = 0; i < history.size() / 2; i++) {
            listItems.add(history.get("title" + i));
            dateItems.add(history.get("date" + i));
        }
        simpleArrayAdapter = new MySimpleArrayAdapter(getContext(), listItems, dateItems, HistoryFragment.this);
        listView.setAdapter(simpleArrayAdapter);
        listView.setItemsCanFocus(true);
        return view;
    }

    @Override
    public void onClick(View v) {

    }

}

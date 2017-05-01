package com.mossartscenter.mossartscenterpatrons.Fragments;

/**
 * Created by AlexBrothers on 4/30/17.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mossartscenter.mossartscenterpatrons.R;

import java.util.ArrayList;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;
    private final ArrayList<String> dates;
    HistoryFragment frag;
    private int i = 0;

    public MySimpleArrayAdapter(Context context, ArrayList<String> values, ArrayList<String> dates, HistoryFragment frag) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.dates = dates;
        this.frag = frag;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row    , parent, false);
        rowView.setClickable(true);
        rowView.setFocusable(true);
        final TextView textView = (TextView) rowView.findViewById(R.id.historyTitle);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.historyImage);
        TextView date = (TextView) rowView.findViewById(R.id.historyDate);
        textView.setText(values.get(position));
        if (values.get(position).compareTo("Roanoke Symphony Orchestra, Masterworks: Musical Travelogue") == 0) {
            imageView.setImageResource(R.drawable.orchestra);
        }
        else {
            imageView.setImageResource(R.drawable.romeoandjuliet);
        }
        date.setText(dates.get(position));
        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                if (textView.getText().toString().compareTo("Roanoke Symphony Orchestra, Masterworks: Musical Travelogue") == 0) {
                    bundle.putInt("titleNumber", 1);
                }
                else {
                    bundle.putInt("titleNumber", 4);
                }
                FragmentManager fragmentManager = frag.getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                ShowFragment showFragment = new ShowFragment();
                showFragment.setArguments(bundle);
                transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, showFragment);
                transaction.commit();
            }

        });

        // change the icon for Windows and iPhone
        return rowView;
    }
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }
}

package com.mossartscenter.mossartscenterpatrons.Fragments;

/**
 * Created by AlexBrothers on 4/30/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.R;

import java.util.ArrayList;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;
    private final ArrayList<String> dates;
    private int i = 0;

    public MySimpleArrayAdapter(Context context, ArrayList<String> values, ArrayList<String> dates) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.dates = dates;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row    , parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.historyTitle);
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

        // change the icon for Windows and iPhone
        return rowView;
    }
}

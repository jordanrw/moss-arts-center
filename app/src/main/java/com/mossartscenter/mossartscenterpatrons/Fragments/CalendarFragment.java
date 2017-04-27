package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.R;

/**
 * Created by Jordan on 4/22/17.
 */

public class CalendarFragment extends Fragment implements View.OnClickListener {

    TextView label;
    Button button;
    int times;

    public void CalendarFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        button = (Button) view.findViewById(R.id.button);
        label = (TextView) view.findViewById(R.id.label);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        times++;
        label.setText("Button was tapped " + times + "times");
    }
}

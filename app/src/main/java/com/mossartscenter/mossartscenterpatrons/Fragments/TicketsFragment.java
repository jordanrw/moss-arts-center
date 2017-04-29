package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.R;

/**
 * Created by Jordan on 4/22/17.
 */

public class TicketsFragment extends Fragment implements View.OnClickListener {
    TextView label;

    public void TicketsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        //label = (TextView) view.findViewById(R.id.ticketsTitle);

        //View view = inflater.inflate(R.layout.fragment_tickets, container, false);


        View v = new View (getActivity());
        v = inflater.inflate(R.layout.fragment_tickets, container, false);

        LinearLayout layout = (LinearLayout) v.findViewById(R.id.linear);


        //inearLayout layout = (LinearLayout) getActivity().findViewById(R.id.linear);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.qrcode1));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }

        return v;
    }

    @Override
    public void onClick(View v) {

    }
}

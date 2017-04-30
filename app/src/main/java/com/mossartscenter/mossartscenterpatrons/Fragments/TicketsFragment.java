package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.HorizontalListView;
import com.mossartscenter.mossartscenterpatrons.MainActivity;
import com.mossartscenter.mossartscenterpatrons.R;
import com.mossartscenter.mossartscenterpatrons.ShowParserJSON;

/**
 * Created by Jordan on 4/22/17.
 */

public class TicketsFragment extends Fragment {

    HorizontalListView listView;
    ShowParserJSON showParserJSON = new ShowParserJSON(MainActivity.contextVar);

    public void TicketsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = new View(getActivity());
        v = inflater.inflate(R.layout.fragment_tickets, container, false);
        listView = (HorizontalListView) v.findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        return v;
    }


    /**
     * MAKE CHANGES TO THESE TWO STATIC VARIABLES IN ORDER TO DYNAMICALLY CHANGE HOW MANY TICKETS
     * ARE DISPLAYED
     * POPULATE DATA OBJECTS WITH THE PARENT DATA RETURNED FROM JSON FILES
     */
    private String[] dataObjects = new String[]{"Belonging",
            "StuartPimslerDanceandTheater",
            "NewYorkGilbertandSullivanPlayers"};

    private String[] ticketCode = new String[]{"qrcode1", "qrcode2", "qrcode3"};

    private BaseAdapter mAdapter = new BaseAdapter() {

        /**
         * THIS DETERMINES HOW MANY TICKETS TO DISPLAY ON THE SCREEN
         * @return
         */
        @Override
        public int getCount() {
            return dataObjects.length;
        }

        @Override
        public Object getItem(int position) {
            Log.d("TicketFragment", "Click on position: " + position);
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, null);
            TextView title = (TextView) retval.findViewById(R.id.title);
            title.setText(showParserJSON.getTitle(dataObjects[position]));
            TextView time = (TextView) retval.findViewById(R.id.showTime);
            time.setText(showParserJSON.getDate(dataObjects[position]));
            TextView desc = (TextView) retval.findViewById(R.id.showDescription);
            desc.setText(showParserJSON.getDescription((dataObjects[position])));

            ImageView image = (ImageView) retval.findViewById(R.id.image);
            int bitmapResourceID = getResources().getIdentifier(ticketCode[position], "drawable", getContext().getPackageName());
            image.setImageResource(bitmapResourceID);

            return retval;
        }
    };
}

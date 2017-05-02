package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.R;

/**
 * Created by Jordan on 4/22/17.
 */

public class SettingsFragment extends Fragment implements View.OnClickListener {
    Switch notificationSwtich;
    Button logoutButton;
    TextView text;

    int i = 1;

    public void SettingsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Button
        logoutButton = (Button) view.findViewById(R.id.settings_logout);
        logoutButton.setOnClickListener(this);
        text = (TextView) view.findViewById(R.id.settings_notif_descrip);

        // Notification Switch
        //SharedPreferences myPrefs = getApplicationContext().getSharedPreferences("notifs", Context.MODE_PRIVATE);
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int notifStatus = sharedPref.getInt("notifications", 0);

        notificationSwtich = (Switch) view.findViewById(R.id.settings_switch);
        if (notifStatus == 0) {
            notificationSwtich.setChecked(false);
        } else {
            notificationSwtich.setChecked(true);
        }
        notificationSwtich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {
                    text.setText("switchOn");
                    editor.putInt("notifications", 1);
                    editor.commit();
                } else {
                    text.setText("switchOff");
                    editor.putInt("notifications", 0);
                    editor.commit();
                }
            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == logoutButton.getId()) {
            // Log out
        }
    }
}

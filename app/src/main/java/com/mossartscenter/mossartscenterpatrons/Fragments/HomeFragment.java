package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.MainActivity;
import com.mossartscenter.mossartscenterpatrons.R;
import com.mossartscenter.mossartscenterpatrons.ShowParserJSON;

import org.w3c.dom.Text;

/**
 * Created by Jordan on 4/22/17.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    ImageView currentGalleryImage;
    TextView currentGalleryTitle;
    TextView currentGalleryDate;
    TextView currentGalleryDescription;

    ImageView nextShowImage;
    TextView nextShowTitle;
    TextView nextShowDate;
    TextView nextShowDescription;

    ImageView suggestedShowImage;
    TextView suggestedShowTitle;
    TextView suggestedShowDate;
    TextView suggestedShowDescription;

    ShowParserJSON parser;

    public void HomeFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the Views
        this.findViews(inflater, container, view);

        // Set onClickListeners
        this.setListeners();

        // Set text from the JSON
        this.setTextFromJSON();

        return view;
    }

    private void findViews(LayoutInflater inflater, ViewGroup container, View view) {
        currentGalleryImage = (ImageView) view.findViewById(R.id.home_image1);
        currentGalleryTitle = (TextView) view.findViewById(R.id.home_title1);
        currentGalleryDate = (TextView) view.findViewById(R.id.home_date1);
        currentGalleryDescription = (TextView) view.findViewById(R.id.home_description1);

        nextShowImage = (ImageView) view.findViewById(R.id.home_image2);
        nextShowTitle = (TextView) view.findViewById(R.id.home_title2);
        nextShowDate = (TextView) view.findViewById(R.id.home_date2);
        nextShowDescription = (TextView) view.findViewById(R.id.home_description2);

        suggestedShowImage = (ImageView) view.findViewById(R.id.home_image3);
        suggestedShowTitle = (TextView) view.findViewById(R.id.home_title3);
        suggestedShowDate = (TextView) view.findViewById(R.id.home_date3);
        suggestedShowDescription = (TextView) view.findViewById(R.id.home_description3);
    }

    private void setListeners() {
        currentGalleryImage.setOnClickListener(this);
        nextShowImage.setOnClickListener(this);
        suggestedShowImage.setOnClickListener(this);
    }

    private void setTextFromJSON() {
        parser = new ShowParserJSON(MainActivity.contextVar, "homeinfo");

        currentGalleryTitle.setText(parser.getTitle("current-gallery"));
        currentGalleryDate.setText(parser.getDate("current-gallery"));
        currentGalleryDescription.setText(parser.getDescription("current-gallery"));

        nextShowTitle.setText(parser.getTitle("next-show"));
        nextShowDate.setText(parser.getDate("next-show"));
        nextShowDescription.setText(parser.getDescription("next-show"));

        suggestedShowTitle.setText(parser.getTitle("suggested-show"));
        suggestedShowDate.setText(parser.getDate("suggested-show"));
        suggestedShowDescription.setText(parser.getDescription("suggested-show"));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_image1) {

        } else if (v.getId() == R.id.home_image2) {

        } else if (v.getId() == R.id.home_image3) {

        }
    }
}

package com.macpatrons.mossartscenterpatrons;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ShowTicketsActivity extends AppCompatActivity {

    CustomPagerAdapter customPagerAdapter;
    ViewPager viewPager;

    int[] resources = {R.drawable.qrcode1, R.drawable.qrcode2, R.drawable.qrcode3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tickets);

        customPagerAdapter = new CustomPagerAdapter(this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(customPagerAdapter);
    }
}

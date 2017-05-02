package com.mossartscenter.mossartscenterpatrons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener {

    Button purchase, cancel;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        purchase = (Button) findViewById(R.id.purchase);
        cancel = (Button) findViewById(R.id.btnCancel);

        purchase.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.purchase:
                break;
            case R.id.btnCancel:
                finish();
                break;

        }
    }
}

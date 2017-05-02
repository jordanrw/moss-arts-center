package com.mossartscenter.mossartscenterpatrons;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BuyTicketActivity extends AppCompatActivity implements View.OnClickListener {

    Button purchase, cancel;
    Spinner spinner;
    TextView showtitle, date, price;
    int total, selection, perTicketPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        showtitle = (TextView) findViewById(R.id.title);
        date = (TextView) findViewById(R.id.date);
        purchase = (Button) findViewById(R.id.purchase);
        cancel = (Button) findViewById(R.id.btnCancel);
        spinner = (Spinner) findViewById(R.id.quantity);
        price = (TextView) findViewById(R.id.price);
        Integer[] amount = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, amount);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = (Integer) spinner.getSelectedItem();
                perTicketPrice = Integer.parseInt(price.getText().toString());
                total = selection * perTicketPrice;
                purchase.setText("Purchase ($" + total + ")");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing here
            }
        });

        Intent myIntent = getIntent();
        showtitle.setText(myIntent.getStringExtra("showString"));
        date.setText(myIntent.getStringExtra("date"));

        purchase.setOnClickListener(this);
        cancel.setOnClickListener(this);

        selection = (Integer) spinner.getSelectedItem();
        perTicketPrice = Integer.parseInt(price.getText().toString());
        total = selection * perTicketPrice;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.purchase:
                new AlertDialog.Builder(this)
                        .setTitle("Moss Arts Center Patrons")
                        .setMessage("Confirm purchase of $" + total)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = Toast.makeText(getApplicationContext(), "Purchase request sent for " + showtitle.getText().toString(), Toast.LENGTH_LONG);
                                toast.show();
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                break;
            case R.id.btnCancel:
                finish();
                break;

        }
    }
}

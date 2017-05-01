package com.mossartscenter.mossartscenterpatrons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submit = (Button) findViewById(R.id.btnSubmit);
        cancel = (Button) findViewById(R.id.btnCancel);

        submit.setOnClickListener(this);
        cancel = (Button) findViewById(R.id.btnCancel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel:
                finish();
                break;
            case R.id.btnSubmit:
                Toast.makeText(this, "Feedback submitted, thanks!", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
    }
}

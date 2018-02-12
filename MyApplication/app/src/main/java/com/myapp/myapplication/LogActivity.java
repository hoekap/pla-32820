package com.myapp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        Intent intent = getIntent();
        String log = intent.getStringExtra("Log");
        TextView text = findViewById(R.id.textlog);
        text.setText(log);
    }
}

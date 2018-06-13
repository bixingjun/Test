package com.example.fanqie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fanqie.R;

public class Tongjiactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongjiactivity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

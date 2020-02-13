package com.example.a07droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        TextView tv = findViewById(R.id.textView);
        tv.setText(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
    }
}

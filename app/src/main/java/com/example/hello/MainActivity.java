package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mainTextView=(TextView) findViewById(R.id.mainTextView);
        mainTextView.setText("Hello");
        startActivity(new Intent(this,BlogDetailsActivity.class));
    }
}
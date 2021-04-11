package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        Button skipButton = (Button) findViewById(R.id.skipBtn);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void nextActivity(View view) {
        Intent newIntent = new Intent(StartActivity.this, StartActivity2.class);
        startActivity(newIntent);
        finish();
    }
}
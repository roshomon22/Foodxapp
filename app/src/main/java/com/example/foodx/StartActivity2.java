package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);

        Button button = (Button) findViewById(R.id.startActivity2Btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity2.this, StartActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        Button skipButton2 = (Button) findViewById(R.id.skipBtn2);
        skipButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity2.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
//
        Button backButton1 = (Button) findViewById(R.id.backBtn1);
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity2.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
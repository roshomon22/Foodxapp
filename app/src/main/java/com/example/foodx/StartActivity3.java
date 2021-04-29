package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start3);


        Button button = (Button) findViewById(R.id.startActivity3Btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity3.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button backButton = (Button) findViewById(R.id.backBtn2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity3.this, StartActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
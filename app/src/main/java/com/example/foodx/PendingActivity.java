package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PendingActivity extends AppCompatActivity {
    private Button backbtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        backbtn4= (Button) findViewById(R.id.backBtn4);
        backbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PendingActivity.this,MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
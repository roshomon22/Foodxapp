package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public final int SPLASH_DISPLAY_TIMER = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Intent mainIntent;
                if (user == null) {
                    mainIntent = new Intent(MainActivity.this,StartActivity.class);

                } else {
                    // No user is signed in
                    mainIntent = new Intent(MainActivity.this,MainMenuActivity.class);
                }
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }

            },SPLASH_DISPLAY_TIMER);
        }


    }
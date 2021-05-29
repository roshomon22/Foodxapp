package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    public final int SPLASH_DISPLAY_TIMER = 1500;
    //private Button crashButton= findViewById(R.id.Crashbutton);
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

//        crashButton.setText("Crash!");
//        crashButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                throw new RuntimeException("Test Crash"); // Force a crash
//            }
//        });
//
//        addContentView(crashButton, new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT));
        }


    }
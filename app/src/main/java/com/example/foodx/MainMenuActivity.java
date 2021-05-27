package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainMenuActivity extends AppCompatActivity {

    private Button LogoutBtn;
    private Button PendingRqstBtn;
    private Button ShareFoodBtn;
    private ImageView UserSharedItems;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        mAuth = FirebaseAuth.getInstance();


        LogoutBtn = (Button) findViewById(R.id.logout_button);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(MainMenuActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        PendingRqstBtn = (Button) findViewById(R.id.PendRqstBtn);
        PendingRqstBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, PendingActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ShareFoodBtn = (Button) findViewById(R.id.ShrFoodBtn);
        ShareFoodBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ShareFoodActivity.class);
                startActivity(intent);
                finish();
            }
        });


        UserSharedItems= (ImageView) findViewById(R.id.UserProfile);
        UserSharedItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ShareActivity.class);
                startActivity(intent);
                finish();
            }
        });



        FirebaseDatabase.getInstance().getReference("Posts").child("posts").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        Post post = ds.getValue(Post.class);
                        System.out.println(post.contactNumber + " " +post.Location + " "+ post.itemName + " " + post.expiryDate + " " + post.UserID);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
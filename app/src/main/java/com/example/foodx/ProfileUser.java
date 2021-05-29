package com.example.foodx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileUser extends AppCompatActivity {
    private FirebaseUser user;
    private DatabaseReference reference;
    private String UserID;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users");
        UserID=user.getUid();

        final TextView username=(TextView)findViewById(R.id.textView6);
        final TextView emails=(TextView)findViewById(R.id.textView10);
        final TextView location=(TextView)findViewById(R.id.textView9);
        final TextView numbers=(TextView)findViewById(R.id.textView7);


        back = (Button) findViewById(R.id.button5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileUser.this, MainMenuActivity.class));
            }
        });

        reference.child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile =snapshot.getValue(User.class);
                if(userProfile!= null){
                    String fullName=userProfile.fullName;
                    String email=userProfile.email;
                    String locations=userProfile.location;
                    String number=userProfile.phoneNo;

                    username.setText(fullName);
                    emails.setText(email);
                    location.setText(locations);
                    numbers.setText(number);





                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
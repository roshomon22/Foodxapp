package com.example.foodx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class ShareFoodActivity extends AppCompatActivity {
    private static final String TAG ="ShareFoodActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button BackButton;
    private EditText FoodItemName;
    private EditText PhoneNumber;
    private EditText LocationArea;
    private Button PostButton;
    private String expiryDate;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mUsers;
    private DatabaseReference mPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_food);
        TextView mDisplayDate = (TextView) findViewById(R.id.exp_date);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ShareFoodActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: mm/dd/yy"+ month+ "/" + day + "/" + year);
                String date=month + "/" + day + "/" + year;
                expiryDate = date;
                mDisplayDate.setText(date);
            }
        };
        BackButton = (Button) findViewById(R.id.backBtn6);
        BackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShareFoodActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mPost=FirebaseDatabase.getInstance().getReference().child("Posts");
        mAuth =FirebaseAuth.getInstance();
        mCurrentUser=mAuth.getCurrentUser();
        mUsers=FirebaseDatabase.getInstance().getReference().child("Users").child(mCurrentUser.getUid());


        FoodItemName = (EditText) findViewById(R.id.food_item_name);
        LocationArea = (EditText) findViewById(R.id.location_area);
        PhoneNumber = (EditText) findViewById(R.id.phone_no);
        PostButton = (Button) findViewById(R.id.post_btn);

        PostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FoodItemNameString = FoodItemName.getText().toString();
                String LocationAreaString = LocationArea.getText().toString();
                String PhoneNumberString = PhoneNumber.getText().toString();
                String UserID = FirebaseAuth.getInstance().getCurrentUser().getUid();



                Post post = new Post(FoodItemNameString, LocationAreaString, PhoneNumberString, UserID,expiryDate);
//                Log.d("Food item", FoodItemNameString);
//                Log.d("Phone Number", PhoneNumberString);
//                Log.d("UserID", UserID);

                if(!TextUtils.isEmpty(FoodItemNameString) &&!TextUtils.isEmpty(PhoneNumberString) && !TextUtils.isEmpty(LocationAreaString))
                {     final DatabaseReference newPost = mPost.push();
                    mUsers.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            newPost.child("contactNumber").setValue(PhoneNumberString);
                            newPost.child("expiryDate").setValue(expiryDate);
                            newPost.child("itemName").setValue(FoodItemNameString);
                            newPost.child("location").setValue(LocationAreaString);
                            newPost.child("userID").setValue(UserID);
                            newPost.child("username").setValue(snapshot.child("fullName").getValue()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {Toast.makeText(ShareFoodActivity.this, "Post was added", Toast.LENGTH_LONG).show();
                                        sendToMain();
                                    }
                                    else
                                    {
                                        String eMsg = task.getException().getMessage();
                                        Toast.makeText(ShareFoodActivity.this, "error: " + eMsg, Toast.LENGTH_LONG).show();

                                    }

                                }
                            });


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



                }



            }
        });


    }
    private void sendToMain() {
        Intent mainMenuIntent = new Intent(ShareFoodActivity.this,MainMenuActivity.class);
        startActivity(mainMenuIntent);
        finish();
    }
}
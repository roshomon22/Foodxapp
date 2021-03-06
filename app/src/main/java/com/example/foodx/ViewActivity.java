package com.example.foodx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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

public class ViewActivity extends AppCompatActivity {
    private Button button3;
    private Button back_button;
    private Button chat;
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private DatabaseReference mPend;
    private DatabaseReference mPost;
    private EditText FoodItemName;
    private EditText PhoneNumber;
    private EditText LocationArea;
    private Button PostButton;
    private String expiryDate;
    TextView tv1, tv2, tv3, tv4, tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView3);
        tv3 = (TextView) findViewById(R.id.textView4);
        tv4 = (TextView) findViewById(R.id.textView2);
        tv5 = (TextView) findViewById(R.id.textView5);
        tv6=(TextView)findViewById(R.id.textView11);
        tv1.setText(getIntent().getStringExtra("itemName"));
        tv2.setText(getIntent().getStringExtra("Location"));
        tv3.setText(getIntent().getStringExtra("Number"));
        tv4.setText(getIntent().getStringExtra("Username"));
        tv5.setText(getIntent().getStringExtra("Expiry"));
        tv6.setText(getIntent().getStringExtra("quantity"));
        String uid= getIntent().getStringExtra("userid");
        mPend = FirebaseDatabase.getInstance().getReference().child("Pending");
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        mPost = FirebaseDatabase.getInstance().getReference().child("Posts");
        String ItemName = getIntent().getStringExtra("itemName");
        String location = getIntent().getStringExtra("Location");
        String UserName = getIntent().getStringExtra("Username");
        String Quantity = getIntent().getStringExtra("quantity");
        chat=findViewById((R.id.b_ch));
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this, MessageActivity.class);
                intent.putExtra("userid",uid);
                startActivity(intent);
                finish();

            }
        });


        back_button=findViewById(R.id.item_view_back_btn);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });


        button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    // Pending request sotrage
                    String curUserID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    Pend pend = new Pend(ItemName,location, UserName,Quantity);
                    FirebaseDatabase.getInstance().getReference("Pending").child(curUserID).push().setValue(pend);

                    //Incoming Storage
                    Incoming incoming = new Incoming(ItemName,location,curUserID);
                    FirebaseDatabase.getInstance().getReference("Incoming").child(uid).push().setValue(incoming);


                startActivity(new Intent(ViewActivity.this, PendingActivity.class));

            }
        });

    }
}
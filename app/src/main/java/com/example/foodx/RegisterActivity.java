package com.example.foodx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText registerNameText;
    private EditText registerPhoneText;
    private EditText registerEmailText;
    private EditText registerPassText;
    private EditText registerLocation;
    private Button registerBtn;
    private Button Backtostrt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmailText = (EditText) findViewById(R.id.reg_email);
        registerPassText = (EditText) findViewById(R.id.reg_pass);
        registerNameText = (EditText) findViewById(R.id.reg_name);
        registerPhoneText = (EditText) findViewById(R.id.reg_phone);
        registerLocation = (EditText) findViewById(R.id.reg_location);
        mAuth = FirebaseAuth.getInstance();
        registerBtn = (Button) findViewById(R.id.reg_btn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registerEmail = registerEmailText.getText().toString();
                String registerPass = registerPassText.getText().toString();
                String registerPhone = registerPhoneText.getText().toString();
                String registerName = registerNameText.getText().toString();
                String registerLoc = registerLocation.getText().toString();

                if(!TextUtils.isEmpty(registerEmail) &&!TextUtils.isEmpty(registerPhone) && !TextUtils.isEmpty(registerName) && !TextUtils.isEmpty(registerPass))
                {
                    mAuth.createUserWithEmailAndPassword(registerEmail, registerPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {

                                User user = new User(registerName, registerEmail, registerPhone, registerLoc,"0");
                                user.setId(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                        {

                                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                                            sendToMain();
                                        }
                                        else
                                        {
                                            String eMsg = task.getException().getMessage();
                                            Toast.makeText(RegisterActivity.this, "error: " + eMsg, Toast.LENGTH_LONG).show();

                                        }

                                    }
                                });
                            }else
                            {
                                Toast.makeText(RegisterActivity.this, "error: Registration Failed ", Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });

        Backtostrt=(Button) findViewById(R.id.backBtn);
        Backtostrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToStart();
            }
        });


    }
    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null)
        {
            sendToMain();
        }
    }

    private void sendToMain() {
        Intent mainMenuIntent = new Intent(RegisterActivity.this,MainMenuActivity.class);
        startActivity(mainMenuIntent);
        finish();
    }
    private void sendToStart() {
        Intent welcomeIntent = new Intent(RegisterActivity.this,WelcomeActivity.class);
        startActivity(welcomeIntent);
        finish();
    }

}


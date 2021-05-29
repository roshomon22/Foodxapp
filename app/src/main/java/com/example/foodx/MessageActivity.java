package com.example.foodx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    TextView username;
    FirebaseUser fuser;
    DatabaseReference reference;
    Intent intent;
    ImageButton send_btn;
    EditText send_text;
    MessageAdapter messageAdapter;
    List<Chat> mchat;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        username = findViewById(R.id.usrname);
        send_btn = findViewById(R.id.btn_send);
        send_text = findViewById(R.id.text_send);
        recyclerView = findViewById(R.id.chat_recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        intent = getIntent();

        String UserId = intent.getStringExtra("userid");
        fuser = FirebaseAuth.getInstance().getCurrentUser();

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = send_text.getText().toString();
                if (!msg.equals("")){
                    sendMessage(fuser.getUid(), UserId, msg);
                }else{
                    Toast.makeText(MessageActivity.this, "you can't send empty message ", Toast.LENGTH_SHORT).show();
                }
                send_text.setText("");
            }
        });
        Log.d("checking in ", "onCreate: "+ UserId);
        reference = FirebaseDatabase.getInstance().getReference("Users").child(UserId);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                Log.d("compare:",fuser.getUid()+" "+UserId);
                username.setText(user.getFullName());
                readMessage(fuser.getUid(),UserId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void sendMessage(String sender, String reciever, String message){

        DatabaseReference reference  =  FirebaseDatabase.getInstance().getReference();

        HashMap< String, Object> hashMap= new HashMap<>();
        hashMap.put("sender",sender );
        hashMap.put("receiver",reciever);
        hashMap.put("message",message);

        reference.child("Chats").push().setValue(hashMap);
    }

    private void readMessage(String myid,String userid)
    {
        mchat = new ArrayList<Chat>();

        reference = FirebaseDatabase.getInstance().getReference("Chats");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mchat.clear();
                for ( DataSnapshot snapshot1: snapshot.getChildren())
                {
                    Chat chat =snapshot1.getValue(Chat.class);
                    Log.d("compare inside readmessage:",myid+" "+userid);
                    if (chat.getReceiver() != null && chat.getReceiver().equals(userid) && chat.getSender().equals(myid) || chat.getReceiver() != null && chat.getReceiver().equals(myid) && chat.getSender().equals(userid))
                    {
                        mchat.add(chat);
                    }
                    messageAdapter = new MessageAdapter(MessageActivity.this,mchat);
                    recyclerView.setAdapter(messageAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
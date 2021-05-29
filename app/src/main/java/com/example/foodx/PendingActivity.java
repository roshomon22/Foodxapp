package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PendingActivity extends AppCompatActivity {

    private Button backbtn4;
    private RecyclerView recView3;
    private MyAdapter2 adapter2;
    private ArrayList<Pend> list2;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase1= FirebaseDatabase.getInstance();
    private DatabaseReference pendRef = mDatabase1.getInstance().getReference("Pending").child(FirebaseAuth.getInstance().getCurrentUser().getUid());



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);
        recView3 = (RecyclerView) findViewById(R.id.recView3);
        recView3.setHasFixedSize(true);
        recView3.setLayoutManager(new LinearLayoutManager(this));
        list2 =new ArrayList<Pend>();
        adapter2 = new MyAdapter2(this,list2);
        recView3.setAdapter(adapter2);
        mAuth = FirebaseAuth.getInstance();


        backbtn4= (Button) findViewById(R.id.backBtn4);
        backbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PendingActivity.this,MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        pendRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Pend Pend = ds.getValue(Pend.class);
                    //Log.d("foodskipped:", "onDataChange: skipping item "+pend.getUserID()+" "+UserID);
                   list2.add(Pend);
                }
                adapter2.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });



    }

}
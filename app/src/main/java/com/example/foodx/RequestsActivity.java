package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodx.Incoming;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RequestsActivity extends AppCompatActivity {
    private Button button4;
    private RecyclerView recView4;
    private MyAdapter3 adapter3;
    private ArrayList<Incoming> list3;
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase1= FirebaseDatabase.getInstance();
    private DatabaseReference pendRef = mDatabase1.getInstance().getReference("Incoming").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        recView4 = (RecyclerView) findViewById(R.id.recView4);
        recView4.setHasFixedSize(true);
        recView4.setLayoutManager(new LinearLayoutManager(this));
        list3 =new ArrayList<Incoming>();
        adapter3 = new MyAdapter3(this,list3);
        recView4.setAdapter(adapter3);
        mAuth = FirebaseAuth.getInstance();

        button4= (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RequestsActivity.this,MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });


        pendRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {


                    Incoming Incoming = ds.getValue(Incoming.class);
                    //Log.d("foodskipped:", "onDataChange: skipping item "+pend.getUserID()+" "+UserID);
                    list3.add(Incoming);
                }
                adapter3.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });


    }
}
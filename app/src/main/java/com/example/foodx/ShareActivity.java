package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class ShareActivity extends AppCompatActivity {
    private Button backbtn5;
    private RecyclerView recView1;
    private MyAdapter1 adapter1;
    private ArrayList<Post> list1;
    private FirebaseDatabase mDatabase= FirebaseDatabase.getInstance();
    private final DatabaseReference RootRef = mDatabase.getInstance().getReference();
    private final DatabaseReference usersRef=RootRef.child("Users");
    private final DatabaseReference postsRef=RootRef.child("Posts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        recView1 = findViewById(R.id.recView1);
        recView1.setHasFixedSize(true);
        recView1.setLayoutManager(new LinearLayoutManager(this));
        list1 = new ArrayList<>();
        adapter1 = new MyAdapter1(this,list1);
        recView1.setAdapter(adapter1);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        backbtn5= findViewById(R.id.backBtn5);
        backbtn5.setOnClickListener(view -> startActivity(new Intent(ShareActivity.this, MainMenuActivity.class)));

                String UserID = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();

                postsRef.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Post post = ds.getValue(Post.class);
                            assert post != null;
                            if (post.getUserID().equals(UserID )){
                                // Log.d("foodskipped:", "onDataChange: skipping item "+post.getUserID()+" "+UserID);
                                list1.add(post);
                            }
                            adapter1.notifyDataSetChanged();
                        }

                    }



                    @Override
                    public void onCancelled(@NotNull DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });


    }
}
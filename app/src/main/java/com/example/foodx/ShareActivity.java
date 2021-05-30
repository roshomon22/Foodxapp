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

import java.util.ArrayList;

public class ShareActivity extends AppCompatActivity {
    private Button backbtn5;
    private RecyclerView recView1;
    private MyAdapter1 adapter1;
    private ArrayList<Post> list1;
    private FirebaseDatabase mDatabase= FirebaseDatabase.getInstance();
    private DatabaseReference RootRef = mDatabase.getInstance().getReference();
    private DatabaseReference usersRef=RootRef.child("Users");
    private DatabaseReference postsRef=RootRef.child("Posts");
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        recView1 = (RecyclerView) findViewById(R.id.recView1);
        recView1.setHasFixedSize(true);
        recView1.setLayoutManager(new LinearLayoutManager(this));
        list1 =new ArrayList<Post>();
        adapter1 = new MyAdapter1(this,list1);
        recView1.setAdapter(adapter1);
        mAuth = FirebaseAuth.getInstance();

        backbtn5= (Button) findViewById(R.id.backBtn5);
        backbtn5.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            startActivity(new Intent(ShareActivity.this, MainMenuActivity.class));
                                        }
                                    });

                String UserID =FirebaseAuth.getInstance().getCurrentUser().getUid();
                //String userLoc = FirebaseAuth.getInstance().getCurrentUser().;
//        FirebaseDatabase.getInstance().getReference("Users/" + UserID).addValueEventListener(new ValueEventListener() {
//
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                   User user = dataSnapshot.getValue(User.class);
//                    System.out.println(user.location);
//
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }
//        });


                postsRef.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Post post = ds.getValue(Post.class);
                            if (post.getUserID().equals(UserID )){
                                // Log.d("foodskipped:", "onDataChange: skipping item "+post.getUserID()+" "+UserID);
                                list1.add(post);
                            }
                            adapter1.notifyDataSetChanged();
                        }

                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });


    }
}
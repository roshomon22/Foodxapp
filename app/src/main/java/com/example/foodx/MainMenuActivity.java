package com.example.foodx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.sql.Ref;
import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {
    private RecyclerView recView;
    private MyAdapter adapter;
    private ArrayList<Post> list;
    private FirebaseDatabase mDatabase= FirebaseDatabase.getInstance();
    private DatabaseReference RootRef = mDatabase.getInstance().getReference();
    private DatabaseReference usersRef=RootRef.child("Users");
    private DatabaseReference postsRef=RootRef.child("Posts");
    private Button LogoutBtn;
    private Button PendingRqstBtn;
    private Button ShareFoodBtn;
    private Button UserSharedItems;
    private Button button2;
    private ImageView user;
    private FirebaseAuth mAuth;
    private ImageView myrequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        recView = (RecyclerView) findViewById(R.id.recView);
        recView.setHasFixedSize(true);
        recView.setLayoutManager(new LinearLayoutManager(this));
        list =new ArrayList<Post>();
        adapter = new MyAdapter(this,list);
        recView.setAdapter(adapter);
        mAuth = FirebaseAuth.getInstance();

        myrequest = (ImageView) findViewById(R.id.MyRequests);
        myrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this,ChatView.class));
            }
        });

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
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, RequestsActivity.class);
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


        UserSharedItems = (Button) findViewById(R.id.button);
        UserSharedItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, ShareActivity.class));
            }
        });

        user = (ImageView) findViewById(R.id.UserProfile);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this, ProfileUser.class));
            }
        });



        String UserID =FirebaseAuth.getInstance().getCurrentUser().getUid();
        //String userLoc = CurrentUser.location;
//        FirebaseDatabase.getInstance().getReference("Users/" + UserID).addValueEventListener(new ValueEventListener() {
//
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                   User user = dataSnapshot.getValue(User.class);
//                    System.out.println(user.location);
//
//            }
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
                    Log.d("foodskipped:", "onDataChange: skipping item "+post.getUserID()+" "+UserID);
                    if (!post.getUserID().equals(UserID)){
                       // Log.d("foodskipped:", "onDataChange: skipping item "+post.getUserID()+" "+UserID);
                        list.add(post);
                    }else {continue;}
                }
                adapter.notifyDataSetChanged();
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });



    }
}



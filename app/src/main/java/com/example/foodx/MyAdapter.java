package com.example.foodx;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    ArrayList<Post> pList;


    Context context;


    public MyAdapter(Context context, ArrayList<Post> pList){
        this.pList=pList;
        this.context=context;

    }

    


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_view_food,parent,false);


        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String UserID =FirebaseAuth.getInstance().getCurrentUser().getUid();
        final Post temp=pList.get(position);
        Post post=pList.get(position);
            holder.itemName.setText(post.getItemName());
            holder.Location.setText(post.getLocation());
            holder.View1.setOnClickListener((view)->{
                Intent intent =new Intent(context, ViewActivity.class);
                intent.putExtra("itemName",temp.getItemName());
                intent.putExtra("Location",temp.getLocation());
                intent.putExtra("Number",temp.getContactNumber());
                intent.putExtra("Expiry",temp.getExpiryDate());
                intent.putExtra("Username",temp.getUsername());
                intent.putExtra("quantity",temp.getQuantity());
                intent.putExtra("userid", temp.getUserID());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                
            });


                    



    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName,Location;
        Button View1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

             itemName = itemView.findViewById(R.id.userid);
             Location =itemView.findViewById(R.id.food_1);
             View1=itemView.findViewById(R.id.view1234);

        }

    }

}

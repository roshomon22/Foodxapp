package com.example.foodx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

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
        Post post=pList.get(position);

            holder.Location.setText(post.getLocation());
            holder.itemName.setText(post.getItemName());


    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemName, Location;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

             itemName = itemView.findViewById(R.id.userid);
            Location =itemView.findViewById(R.id.food_1);

        }

    }

}

package com.example.foodx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    ArrayList<Post> pList;
    ArrayList<Post> uList;

    Context context;

    public MyAdapter(Context context, ArrayList<Post>pList){
        this.pList=pList;
        this.uList=uList;
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
        Post post=pList.get(position);
        holder.UserID.setText(post.getUserID());
        holder.itemName.setText(post.getItemName());

    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView itemName, UserID;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            UserID=itemView.findViewById(R.id.userid);
            itemName =itemView.findViewById(R.id.food_1);

        }
    }

}

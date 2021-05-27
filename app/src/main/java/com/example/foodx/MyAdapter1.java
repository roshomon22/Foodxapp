package com.example.foodx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder>{
    ArrayList<User> uList;


    Context context;

    public MyAdapter1(Context context, ArrayList<User> uList){
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
        User user=uList.get(position);
        holder.fullName.setText(user.getFullName());


    }

    @Override
    public int getItemCount() {
        return uList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView  fullName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName=itemView.findViewById(R.id.userid);
            ;

        }
    }

}


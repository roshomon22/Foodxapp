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
    ArrayList<Post> mList;
    Context context;

    public MyAdapter(Context context, ArrayList<Post>mList){
        this.mList=mList;
        this.context=context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.share_food_holder,parent,false);
        return new MyViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Post model=mList.get(position);
        holder.user.setText(model.getUserID());
        holder.fooditem.setText(model.getItemName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView user , fooditem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            user=itemView.findViewById(R.id.userid);
            fooditem =itemView.findViewById(R.id.food_1);

        }
    }

}

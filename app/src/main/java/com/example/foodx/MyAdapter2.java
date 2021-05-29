package com.example.foodx;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.YvViewHolder>{
    ArrayList<Pend> pList2;


    Context context2;


    public MyAdapter2 (Context context1, ArrayList<Pend> pList2){
        this.pList2=pList2;
        this.context2=context1;

    }


    @NonNull
    @Override
    public YvViewHolder onCreateViewHolder(@NonNull ViewGroup parent2, int viewType) {
        View s = LayoutInflater.from(context2).inflate(R.layout.view_pending_act,parent2,false);


        return new YvViewHolder(s);


    }

    @Override
    public void onBindViewHolder(@NonNull YvViewHolder holder2, int position2) {
        String UserID =FirebaseAuth.getInstance().getCurrentUser().getUid();

        Pend Pend =pList2.get(position2);
        holder2.itemName.setText(Pend.getItem());
        holder2.Location.setText(Pend.getLocation());
        holder2.UserName.setText(Pend.getUserName());
        holder2.Quantity.setText(Pend.getQuantity());






    }

    @Override
    public int getItemCount() {
        return pList2.size();
    }

    public class YvViewHolder extends RecyclerView.ViewHolder {

        TextView itemName,Location, UserName, Quantity;



        public YvViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.userid2);
            Location =itemView.findViewById(R.id.food_55);
            UserName = itemView.findViewById(R.id.user1);
            Quantity = itemView.findViewById(R.id.food_13);




        }

    }

}

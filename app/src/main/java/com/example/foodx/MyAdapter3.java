package com.example.foodx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.YrViewHolder>{
    ArrayList<Incoming> pList3;


    Context context3;


    public MyAdapter3(Context context3, ArrayList<Incoming> pList3){
        this.pList3=pList3;
        this.context3=context3;

    }


    @NonNull
    @Override
    public YrViewHolder onCreateViewHolder(@NonNull ViewGroup parent3, int viewType) {
        View t = LayoutInflater.from(context3).inflate(R.layout.view_incom_req,parent3,false);


        return new YrViewHolder(t);


    }

    @Override
    public void onBindViewHolder(@NonNull YrViewHolder holder3, int position3) {

        Incoming Incoming =pList3.get(position3);
        holder3.Item.setText(Incoming.getItem());
        holder3.location.setText(Incoming.getLocation());
       // holder3.ReqUserID.setText(Incoming.getReqUserID());





    }

    @Override
    public int getItemCount() {
        return pList3.size();
    }

    public class YrViewHolder extends RecyclerView.ViewHolder {

        TextView Item,location, ReqUserID;



        public YrViewHolder(@NonNull View itemView) {
            super(itemView);

            Item= itemView.findViewById(R.id.userid3);
            location =itemView.findViewById(R.id.user2);
            //ReqUserID = itemView.findViewById(R.id.userid3);



        }

    }

}

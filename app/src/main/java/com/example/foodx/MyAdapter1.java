package com.example.foodx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.YuViewHolder>{
    ArrayList<Post> pList1;


    Context context1;


    public MyAdapter1(Context context1, ArrayList<Post> pList1){
        this.pList1=pList1;
        this.context1=context1;

    }


    @NonNull
    @Override
    public YuViewHolder onCreateViewHolder(@NonNull ViewGroup parent1, int viewType) {
        View r = LayoutInflater.from(context1).inflate(R.layout.main_view_share,parent1,false);


        return new YuViewHolder(r);


    }

    @Override
    public void onBindViewHolder(@NonNull YuViewHolder holder1, int position1) {
        String UserID =FirebaseAuth.getInstance().getCurrentUser().getUid();

        Post post=pList1.get(position1);
        holder1.itemName.setText(post.getItemName());
        holder1.Location.setText(post.getLocation());
        holder1.Quantity.setText(post.getQuantity());


        holder1.View2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });





    }

    @Override
    public int getItemCount() {
        return pList1.size();
    }

    public class YuViewHolder extends RecyclerView.ViewHolder {

        TextView itemName,Location, Quantity;
        Button View2;



        public YuViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.userid1);
            Location =itemView.findViewById(R.id.food_77);
            Quantity=itemView.findViewById(R.id.food_12);
            View2 =itemView.findViewById(R.id.view123);

        }

    }

}

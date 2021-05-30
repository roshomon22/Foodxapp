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

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context mcontext;
    private List<User> muser;

    public UserAdapter (Context context, List<User> muser)
    {
        this.mcontext=context;
        this.muser=muser;
    }



    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.chats_item,parent,false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User user = muser.get(position);
        Log.d(" GETTING THE USER FOR CHAT VIEW :", user.getId());
        holder.UserName.setText(user.getFullName());
        String uid = user.getId();
        holder.UserName.setOnClickListener((view)->{
            Intent intent =new Intent(mcontext, MessageActivity.class);
            intent.putExtra("userid",uid);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mcontext.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return muser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView UserName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            UserName = itemView.findViewById(R.id.chats_username);


        }

    }
}

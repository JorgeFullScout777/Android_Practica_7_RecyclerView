package com.example.recyclerview.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.MyViewHolder>{
    List<User> userList = new ArrayList<>();
    Context ctx;

    public UserRecyclerAdapter(List<User> userList, Context ctx) {
        this.userList = userList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public UserRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.activity_user, parent, false);
        return new UserRecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRecyclerAdapter.MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.txtName.setText(user.getName());
        holder.txtJob.setText(user.getJob());
        holder.imgv.setImageResource(user.getImage());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv;
        TextView txtName, txtJob;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv = itemView.findViewById(R.id.imgU);
            txtName = itemView.findViewById(R.id.txtName);
            txtJob = itemView.findViewById(R.id.txtJob);
        }
    }
}

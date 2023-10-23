package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapters.UserRecyclerAdapter;
import com.example.recyclerview.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6, R.drawable.p7, R.drawable.p8};
    List<User> users = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllUsers();
        UserRecyclerAdapter adapter = new UserRecyclerAdapter(users, this);
        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getAllUsers(){
        String[] names = getResources().getStringArray(R.array.names_txt);
        String[] jobs = getResources().getStringArray(R.array.job_txt);

        for(int i = 0; i < names.length; i++){
            users.add(new User(names[i], jobs[i], images[i]));
        }
    }
}
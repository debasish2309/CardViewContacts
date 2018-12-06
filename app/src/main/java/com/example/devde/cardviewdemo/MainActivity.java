package com.example.devde.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Simple RecylerView with CardView

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<contact> list = new ArrayList<contact>();
    int[] image_id = {R.drawable.lion1,R.drawable.lion2,R.drawable.lion3,R.drawable.lion4,R.drawable.lion5,
            R.drawable.lion6,R.drawable.lion7,R.drawable.lion8,R.drawable.lion9,R.drawable.lion10,
            R.drawable.lion11,R.drawable.lion12,R.drawable.lion13,R.drawable.lion14,R.drawable.lion15,
            R.drawable.lion16,R.drawable.lion17,R.drawable.lion18,R.drawable.lion19,R.drawable.lion20};
    String[] name,email,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getResources().getStringArray(R.array.person_name);
        email = getResources().getStringArray(R.array.person_email);
        phone = getResources().getStringArray(R.array.person_phone);
        int count = 0;
        for(String Name : name)
        {
            contact contact = new contact(image_id[count],Name,email[count],phone[count]);
            count++;
            list.add(contact);
        }

        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ContactAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }
}

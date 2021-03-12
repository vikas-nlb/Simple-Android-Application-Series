package com.abc.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    public static ArrayList<DetailsClass> items= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        items.add(new DetailsClass("Afghanistan","Kabul","Afghani"));
        items.add(new DetailsClass("Australia","Canberra","Australian Dollar"));
        items.add(new DetailsClass("Bahrain","Manama","Bahraini Dinar"));
        items.add(new DetailsClass("Bangladesh","Dhaka","Taka"));
        items.add(new DetailsClass("Belgium","Brussels","Euro"));
        items.add(new DetailsClass("China","Beijing","Chinese Yuan"));
        items.add(new DetailsClass("Greece","Athens","Euro"));
        items.add(new DetailsClass("India","New Delhi","Indian Rupee"));
        items.add(new DetailsClass("Japan","Tokyo","Yen"));
        items.add(new DetailsClass("United States of America","Washington D.C.","United States Dollar"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdaptor(items);
        recyclerView.setAdapter(adapter);



    }
}
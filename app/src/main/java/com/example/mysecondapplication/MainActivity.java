package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Package> packageArrayList = new ArrayList<>();
        packageArrayList.add(new Package("ABC111", "AAAA", "12", "02-888", "Wrasaw"));
        packageArrayList.add(new Package("ABC222", "BBBB", "13", "02-889", "Wrasaw"));
        packageArrayList.add(new Package("ABC333", "CCCC", "14", "02-810", "Wrasaw"));
        packageArrayList.add(new Package("ABC444", "DDDD", "15", "02-828", "Wrasaw"));
        packageArrayList.add(new Package("ABC555", "EEEE", "16", "02-839", "Wrasaw"));
        packageArrayList.add(new Package("ABC666", "FFFF", "17", "02-840", "Wrasaw"));
        packageArrayList.add(new Package("ABC777", "GGGG", "18", "02-856", "Wrasaw"));
        packageArrayList.add(new Package("ABC888", "HHHH", "19", "02-819", "Wrasaw"));
        packageArrayList.add(new Package("ABC999", "IIII", "20", "02-816", "Wrasaw"));
        packageArrayList.add(new Package("ABC000", "JJJJ", "21", "02-811", "Wrasaw"));
        packageArrayList.add(new Package("ABC101010", "KKKK", "22", "02-999", "Wrasaw"));

        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PackageAdapter(packageArrayList);

        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(adapter);
    }
}
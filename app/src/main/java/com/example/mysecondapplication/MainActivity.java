package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private ArrayList<Package> mExampleList;

    private RecyclerView mrecyclerView;
    private PackageAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExampleList = new ArrayList<>();
        mExampleList.add(new Package("ABC111", "AAAA", "12", "02-888", "Wrasaw"));
        mExampleList.add(new Package("ABC222", "BBBB", "13", "02-889", "Wrasaw"));
        mExampleList.add(new Package("ABC333", "CCCC", "14", "02-810", "Wrasaw"));
        mExampleList.add(new Package("ABC444", "DDDD", "15", "02-828", "Wrasaw"));
        mExampleList.add(new Package("ABC555", "EEEE", "16", "02-839", "Wrasaw"));
        mExampleList.add(new Package("ABC666", "FFFF", "17", "02-840", "Wrasaw"));
        mExampleList.add(new Package("ABC101010", "FFFF", "17", "02-840", "Wrasaw"));

        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PackageAdapter(mExampleList);

        mrecyclerView.setLayoutManager(layoutManager);
        mrecyclerView.setAdapter(adapter);

        adapter.setOnDialogClickListener(new PackageAdapter.onDialogClickListener() {

            @Override
            public void onYesClicked(int position) {
                removeItem(position);
            }

            @Override
            public void onNoClicked() {

            }
        });
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
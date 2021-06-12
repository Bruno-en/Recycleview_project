package com.example.mysecondapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private ArrayList<Package> mExampleList;

    private RecyclerView mrecyclerView;
    private PackageAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public FloatingActionButton floatingAddButton;

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

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
        floatingAddButton = findViewById(R.id.fabAdd);

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
        floatingAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSomeActivityForResult();
            }
        });

    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
    public void insertItem(Package p,int position) {
        mExampleList.add( position, p );
        adapter.notifyItemInserted(position);

    }
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        Package newPackage =  data.getExtras().getParcelable("dodanaPaczka");
                        insertItem(newPackage, 0);
                        mrecyclerView.scrollToPosition(0);
                    }
                }
            });

    public void openSomeActivityForResult() {
        Intent intent = new Intent(this, AddPackageActivity.class);
        someActivityResultLauncher.launch(intent);
    }
}
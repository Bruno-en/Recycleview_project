package com.example.mysecondapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ExampleViewHolder> {
    private ArrayList<Package> PackageList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mpackage_number;
        public TextView text2;
        public TextView text3;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mpackage_number = itemView.findViewById(R.id.textView1);
            text2 = itemView.findViewById(R.id.textView2);
            text3 = itemView.findViewById(R.id.textView3);
        }
    }

    public PackageAdapter(ArrayList<Package> packageArrayList) {
        PackageList = packageArrayList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder viewHolder = new ExampleViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Package currentPackage = PackageList.get(position);
        holder.mpackage_number.setText(currentPackage.getPackage_number());
        holder.text2.setText(currentPackage.getText2());
        holder.text3.setText(currentPackage.getText3());
    }

    @Override
    public int getItemCount() {
        return PackageList.size();
    }
}

package com.example.mysecondapplication;

import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ExampleViewHolder> {
    private ArrayList<Package> PackageList;
    private onDialogClickListener mListener;

    public interface onDialogClickListener{
        void onYesClicked(int position);
        void onNoClicked();
    }

    public void setOnDialogClickListener(onDialogClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mpackage_number;
        public TextView text2;
        public TextView text3;
        Button dialogButton;
        AlertDialog.Builder builder;

        public ExampleViewHolder(View itemView, onDialogClickListener listener) {
            super(itemView);
            mpackage_number = itemView.findViewById(R.id.textView1);
            text2 = itemView.findViewById(R.id.textView2);
            text3 = itemView.findViewById(R.id.textView3);
            dialogButton = itemView.findViewById(R.id.dialog_button);

            builder = new AlertDialog.Builder(dialogButton.getContext());

            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    builder.setMessage("Czy chcesz usunac paczke " + mpackage_number.getText().toString())
                            .setTitle("Uwaga")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    int position = getAbsoluteAdapterPosition();
                                    listener.onYesClicked(position);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Log.d(TAG, "onClick: Nie udalo sie");
                                    //listener.onNoClicked();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
        }
    }

    public PackageAdapter(ArrayList<Package> packageArrayList) {
        PackageList = packageArrayList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder viewHolder = new ExampleViewHolder(v, mListener);
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

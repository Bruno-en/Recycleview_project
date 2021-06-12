package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPackageActivity extends AppCompatActivity {
    private Button confirmButton;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_package);
        confirmButton = findViewById(R.id.button_confirm);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                if(TextUtils.isEmpty(text1)) {
                    editText1.setError("To pole nie może być puste");
                    return;
                }
                String text2 = editText2.getText().toString();
                if(TextUtils.isEmpty(text2)) {
                    editText2.setError("To pole nie może być puste");
                    return;
                }
                String text3 = editText3.getText().toString();
                if(TextUtils.isEmpty(text3)) {
                    editText3.setError("To pole nie może być puste");
                    return;
                }
                String text4 = editText4.getText().toString();
                if(TextUtils.isEmpty(text4)) {
                    editText4.setError("To pole nie może być puste");
                    return;
                }
                String text5 = editText5.getText().toString();
                if(TextUtils.isEmpty(text5)) {
                    editText5.setError("To pole nie może być puste");
                    return;
                }
                Intent intent = new Intent();
                Package newPacage = new Package(text1,text2,text3,text4,text5);
                intent.putExtra("dodanaPaczka", newPacage);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
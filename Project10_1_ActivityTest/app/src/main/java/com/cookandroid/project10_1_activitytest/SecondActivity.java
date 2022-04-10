package com.cookandroid.project10_1_activitytest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button btn2;
    TextView txtContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        btn2 = findViewById(R.id.btn2);
        txtContent = findViewById(R.id.txtContent);

        Intent in = getIntent();

        String name = in.getStringExtra("name");
        int age = in.getIntExtra("age",0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");

        txtContent.setText("이름 : "+name+"\n나이 : "+age+"\n취미 : ");
        for(String h:hobby){
            txtContent.setText(txtContent.getText().toString()+h+" ");
        }
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

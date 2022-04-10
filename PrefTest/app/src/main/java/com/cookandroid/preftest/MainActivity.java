package com.cookandroid.preftest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    EditText editText;
    Button btnSumit;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SharedPreferences 실습 - 김민정");

        editText = findViewById(R.id.editText);
        btnSumit = findViewById(R.id.btnSumit);

        sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        name = sharedPref.getString("name","이름없음");
        editText.setText(name);

        btnSumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor = sharedPref.edit();
                name = editText.getText().toString();
                editor.putString("name",name);
                editor.commit();
            }
        });

    }
}

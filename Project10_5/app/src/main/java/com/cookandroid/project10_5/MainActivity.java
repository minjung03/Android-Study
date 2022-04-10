package com.cookandroid.project10_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [버튼A]");

        btnA = findViewById(R.id.btnA);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ina = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(ina);
            }
        });


    }
}

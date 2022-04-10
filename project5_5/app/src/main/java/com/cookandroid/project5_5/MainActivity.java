package com.cookandroid.project5_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2102김민정");

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setVisibility(view.VISIBLE);
                tv2.setVisibility(view.INVISIBLE);
                tv3.setVisibility(view.INVISIBLE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setVisibility(view.INVISIBLE);
                tv2.setVisibility(view.VISIBLE);
                tv3.setVisibility(view.INVISIBLE);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv1.setVisibility(view.INVISIBLE);
                tv2.setVisibility(view.INVISIBLE);
                tv3.setVisibility(view.VISIBLE);
            }
        });
    }

}



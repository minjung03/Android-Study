package com.cookandroid.proviewflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button btnPre, btnNext, btnStart, btnStop;
    ViewFlipper viewFlip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2102김민정_ViewFlip");

        btnPre=(Button)findViewById(R.id.btnPre);
        btnNext=(Button)findViewById(R.id.btnNext);
        btnStart=(Button)findViewById(R.id.btnStart);
        btnStop=(Button)findViewById(R.id.btnStop);
        viewFlip = (ViewFlipper)findViewById(R.id.viewFlip);

        viewFlip.setFlipInterval(500); // 단위가 ms (500ms)

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.showNext();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlip.stopFlipping();
            }
        });

    }
}

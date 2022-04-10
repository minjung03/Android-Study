package com.cookandroid.tablayout_test;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragExam1_2 extends Fragment {

    Button btnPause, btnStart, btnReset;
    Chronometer chrono;
    private  boolean running = false;
    private  long pauseOffset = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragexam1_2, container, false);

        btnPause = (Button)v.findViewById(R.id.btnPause);
        btnStart = (Button)v.findViewById(R.id.btnStart);
        btnReset = (Button)v.findViewById(R.id.btnReset);
        chrono = (Chronometer)v.findViewById(R.id.chrono);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!running){
                    chrono.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chrono.start();
                    running = true;
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(running){
                    chrono.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chrono.getBase();
                    running = false;
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;
                running = false;
            }
        });

        return v;
    }
}

package com.cookandroid.project11_2_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String[] imgSet =  {"회전","확대","축소","기울기 증가","기울기 감소"};

    Spinner spMovie;
    ImageView imgPoster;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [Spinner 실습]");

        spMovie = findViewById(R.id.spMovie);
        imgPoster = findViewById(R.id.imgPoster);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, imgSet);
        spMovie.setAdapter(adapter);

        spMovie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String text = spMovie.getSelectedItem().toString();
                switch (text){
                    case "회전" :
                        // 나중에 계속 하기!!
                        Toast.makeText(getApplicationContext(),"회전클릭",Toast.LENGTH_SHORT).show();
                        break;
                    case "확대" :
                        break;
                    case "축소" :
                        break;
                    case "기울기 증가" :
                        break;
                    case "기울기 감소" :
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

package com.cookandroid.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdGroup;
    RadioButton rdo1, rdo2, rdo3;
    ImageView ImgView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민정] 파스타 전문점");

        rdGroup = findViewById(R.id.rdGroup);
        rdo1 = findViewById(R.id.rdo1);
        rdo2 = findViewById(R.id.rdo2);
        rdo3 = findViewById(R.id.rdo3);
        ImgView = findViewById(R.id.ImgView);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (rdGroup.getCheckedRadioButtonId()){
                    case R.id.rdo1 :
                        Toast.makeText(getApplicationContext(), rdo1.getText().toString()+"\n주문하셨습니다.", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rdo2 :
                        Toast.makeText(getApplicationContext(), rdo2.getText().toString()+"\n주문하셨습니다.", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rdo3 :
                        Toast.makeText(getApplicationContext(), rdo3.getText().toString()+"\n주문하셨습니다.", Toast.LENGTH_SHORT).show(); break;

                }
            }
        });

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (rdGroup.getCheckedRadioButtonId()){
                    case R.id.rdo1 :
                        ImgView.setImageResource(R.drawable.sea_pasta); break;
                    case R.id.rdo2 :
                        ImgView.setImageResource(R.drawable.tomato_pasta); break;
                    case R.id.rdo3 :
                        ImgView.setImageResource(R.drawable.cream_pasta); break;
                }
            }
        });

    }
}

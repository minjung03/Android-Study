package com.cookandroid.project4_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView Text1, Text2;
    Switch SwiAgree;
    RadioGroup Rgroup1;
    RadioButton Rdo8, Rdo9, Rdo10;
    Button BtnBack, BtnEnd;
    ImageView ImgPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text1 = (TextView) findViewById(R.id.Text1);
        Text2 = (TextView) findViewById(R.id.Text2);
        SwiAgree = (Switch) findViewById(R.id.SwiAgree);
        Rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        Rdo8 = (RadioButton) findViewById(R.id.Rdo8);
        Rdo9 = (RadioButton) findViewById(R.id.Rdo9);
        Rdo10 = (RadioButton) findViewById(R.id.Rdo10);
        BtnBack = (Button) findViewById(R.id.BtnBack);
        BtnEnd = (Button) findViewById(R.id.BtnEnd);
        ImgPet = (ImageView) findViewById(R.id.ImgPet);

        SwiAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (SwiAgree.isChecked() == true) {
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    BtnBack.setVisibility(View.VISIBLE);
                    BtnEnd.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                } else {
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    BtnBack.setVisibility(View.INVISIBLE);
                    BtnEnd.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);
                }

            }
        });
        BtnBack.setOnClickListener(new View.OnClickListener() {  //처음으로
            @Override
            public void onClick(View view) {
                Text2.setVisibility(View.INVISIBLE);
                Rgroup1.setVisibility(View.INVISIBLE);
                BtnBack.setVisibility(View.INVISIBLE);
                BtnEnd.setVisibility(View.INVISIBLE);
                ImgPet.setVisibility(View.INVISIBLE);
                Rgroup1.clearCheck();  // 라디오 버튼 선택 클리어
                SwiAgree.setChecked(false); // 체크 해제
                ImgPet.setImageDrawable(null);  // Image 초기화(없게)
            }
        });
        BtnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Rdo8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ImgPet.setImageResource(R.drawable.oreo);
            }
        });
        Rdo9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ImgPet.setImageResource(R.drawable.pie);
            }
        });
        Rdo10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ImgPet.setImageResource(R.drawable.q10);
            }
        });
    }
}

package com.cookandroid.project10_1_activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    Button btnNew;
    RadioButton rdoSecond; // 라디오 버튼이 두개 밖에 없으니 버튼 하나로 한 것
     */

    EditText edName, edAge;
    CheckBox chkGame, chkMusic, chkSport;
    Button btnSumit;
    String name;
    int age;
    ArrayList<String> hobby = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkSport = findViewById(R.id.chkSport);
        btnSumit = findViewById(R.id.btnSumit);

        chkGame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(chkGame.getText().toString());
                }
                else {
                    hobby.remove(hobby.indexOf(chkGame.getText().toString()));
                }
            }
        });

        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(chkMusic.getText().toString());
                }
                else {
                    hobby.remove(hobby.indexOf(chkMusic.getText().toString()));
                }
            }
        });

        chkSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    hobby.add(chkSport.getText().toString());
                }
                else {
                    hobby.remove(hobby.indexOf(chkSport.getText().toString()));
                }
            }
        });

        btnSumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edName.getText().toString();
                try {
                    age = Integer.parseInt(edAge.getText().toString());
                }
                catch (Exception e){

                }

                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("name", name);
                in.putExtra("age", age);
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });

        /*
        btnNew = findViewById(R.id.btnNew);
        rdoSecond = findViewById(R.id.rdoSecond);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                if(rdoSecond.isChecked() == true){
                    intent = new Intent(getApplicationContext(),SecondActivity.class);
                    intent.putExtra("content","HelloAndroid");
                }
                else intent = new Intent(getApplicationContext(),ThirdActivity.class);
                startActivity(intent);

            }
        });
         */
    }
}

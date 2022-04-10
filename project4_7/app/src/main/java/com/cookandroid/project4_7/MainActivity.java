package com.cookandroid.project4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    CheckBox Enabled,Clickable,H45;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn); // 뒤 쪽은 xml 변수 이름이다!!
        Enabled = (CheckBox)findViewById(R.id.Enabled);
        Clickable = (CheckBox)findViewById(R.id.Clickable);
        H45 = (CheckBox)findViewById(R.id.H45);

        Enabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(Enabled.isChecked()==true){
                    btn.setEnabled(true);
                }
                else{
                    btn.setEnabled(false);
                }
            }
        });
        Clickable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (Clickable.isChecked() == true){
                    btn.setClickable(true);
                } else {
                    btn.setClickable(false);
                }
            }
        });
        H45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(H45.isChecked()==true){
                    btn.setRotation(45);
                }
                else{
                    btn.setRotation(0);
                }
            }
        });

    }
}

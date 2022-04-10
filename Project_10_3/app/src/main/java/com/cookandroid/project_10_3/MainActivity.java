package com.cookandroid.project_10_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtTel, edtAddress;
    Button btnInput;
    RadioGroup rgGender;
    RadioButton rdoMan, rdoWoman;

    String name, tel, address, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [직렬화 실습]");

        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        edtAddress = findViewById(R.id.edtAddress);
        btnInput = findViewById(R.id.btnInput);
        rgGender = findViewById(R.id.rgGender);
        rdoMan = findViewById(R.id.rdoMan);
        rdoWoman = findViewById(R.id.rdoWoman);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = edtName.getText().toString();
                tel = edtTel.getText().toString();
                address = edtAddress.getText().toString();

                if(rgGender.getCheckedRadioButtonId() == R.id.rdoMan){
                    gender = "남자";
                }
                else {
                    gender = "여자";
                }

                Person p = new Person(name, gender, tel, address);
                Intent In = new Intent(getApplicationContext(), ResultActivity.class);
                In.putExtra("person",p);
                startActivity(In);
            }
        });
    }
}

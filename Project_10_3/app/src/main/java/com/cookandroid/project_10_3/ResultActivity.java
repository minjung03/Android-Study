package com.cookandroid.project_10_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    TextView txtResult;
    Person p;
    String name, gender, tel, address;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("김민정 [직렬화 실습]");

        txtResult = findViewById(R.id.txtResult);
        btnReturn = findViewById(R.id.btnReturn);

        Intent in = getIntent();
        p = (Person)in.getSerializableExtra("person");
        name = p.getName();
        gender = p.getGender();
        tel = p.getTel();
        address = p.getAddress();

        txtResult.setText("이름: "+name+"\n성별: "+gender+"\n");
        txtResult.setText(txtResult.getText().toString()+"전화: "+tel+"\n");
        txtResult.setText(txtResult.getText().toString()+"주소: "+address+"\n");

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

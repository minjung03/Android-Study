package com.cookandroid.project10_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {

    Button btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("김민정 [버튼B]");

        btnB = findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inb = new Intent(getApplicationContext(),ThirdActivity.class);
                startActivity(inb);
            }
        });


    }
}

package com.cookandroid.project_10_3_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        btnReturn = findViewById(R.id.btnReturn);

        //넘어온 데이터 정의
        Intent inIntent = getIntent();
        final int num1 = inIntent.getIntExtra("Num1",0);
        final int num2 = inIntent.getIntExtra("Num2",0);
        final Integer Cal = inIntent.getIntExtra("Cal",0);


        /*  방법2. 요런 방식도 가능
        String calc = (inIntent.getStringExtra("Cal"));
        int calValue = 0;

        if(calc.equals("+")){
            calValue = inIntent.getIntExtra("Num1",0)+inIntent.getIntExtra("Num2",0);
        }
        else if(calc.equals("-")){
            calValue = inIntent.getIntExtra("Num1",0)-inIntent.getIntExtra("Num2",0);
        }
        else if(calc.equals("*")){
            calValue = inIntent.getIntExtra("Num1",0)*inIntent.getIntExtra("Num2",0);
        }
        else{
            calValue = inIntent.getIntExtra("Num1",0)%inIntent.getIntExtra("Num2",0);
        }
        final int hapValue = calValue; // 아래 switch구문을 지우고, 보낼 때 result 대신 hapValue 보내면 됨
        */

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int result = 0;

                switch (Cal){
                    case R.id.rdoSum :
                    result = (num1+num2); break;

                    case R.id.rdoOdd :
                        result = (num1-num2); break;

                    case R.id.rdoMul :
                        result = (num1*num2); break;

                    case R.id.rdoDiv :
                        result = (num1%num2); break;
                }

                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("result", result);
                //setResult()로 MainActivity 데이터 전달; main의 onActivityResult()가 실행됨
                setResult(RESULT_OK, outIntent);
                finish(); //현 activity 닫음
            }
        });
    }
}

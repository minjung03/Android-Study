package com.cookandroid.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    // 버은 10개 필요 <- 배열로 만듬
    Button [] numButtons = new Button[10];
    Integer [] numBtnIDs = {R.id.BtnNumber0,R.id.BtnNumber1,R.id.BtnNumber2,R.id.BtnNumber3,R.id.BtnNumber4
            ,R.id.BtnNumber5,R.id.BtnNumber6, R.id.BtnNumber7,R.id.BtnNumber8,R.id.BtnNumber9};

    int i; // 증가값 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(("2102김민정[간단 계산기]"));

        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);

        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);

        textResult = (TextView)findViewById(R.id.TextResult);

        for( i = 0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산결과 : "+result.toString());
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과 : "+result.toString());
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과 : "+result.toString());
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(Integer.parseInt(num2) != 0){
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textResult.setText("계산결과 : "+result.toString());
                }
                else { // 0으로는 나눌 수 없으니
                    Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다.",Toast.LENGTH_LONG).show();
                    textResult.setText("계산결과 : 없음");

                }

            }
        });

        // 버튼 10개에 대해 이벤트 처리
        for(i = 0; i<numBtnIDs.length; i++){

            final int index; //익명 클래스 안에서 사용될 첨자
            index = i;

            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 포커스가 되어있는 에디터에 숫자를 추가
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString(); // 익명클래스 사용 시 final 변수 사용!
                        edit1.setText(num1);
                    }
                    else if(edit2.isFocused() == true){
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();  // 익명클래스 사용 시 final 변수 사용!
                        edit2.setText(num2);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 클릭하세요",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }
}

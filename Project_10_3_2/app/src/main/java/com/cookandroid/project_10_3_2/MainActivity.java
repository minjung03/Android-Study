package com.cookandroid.project_10_3_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    Button btnNewActivity;
    EditText edtNum1, edtNum2;

    Button btnRe;
    RadioGroup rgCal;
    RadioButton rdoSum, rdoOdd, rdoMul, rdoDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [양방향 실습]");


        rgCal = findViewById(R.id.rgCal);
        rdoSum = findViewById(R.id.rdoSum);
        rdoOdd = findViewById(R.id.rdoOdd);
        rdoMul = findViewById(R.id.rdoMul);
        rdoDiv = findViewById(R.id.rdoDiv);


        btnRe = findViewById(R.id.btnRe);
        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNum1 = findViewById(R.id.edtNum1);
                edtNum2 = findViewById(R.id.edtNum2);

                //intent 선언
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //넘겨줄 데이터 정의
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));
                /* 방법2. 이렇게 넘겨도 ok
                switch (rgCal.getCheckedRadioButtonId()){
                    case R.id.rdoSum : intent.putExtra("Cal", "+"); break;
                    case R.id.rdoOdd : intent.putExtra("Cal", "-"); break;
                    case R.id.rdoMul : intent.putExtra("Cal", "*"); break;
                    case R.id.rdoDiv : intent.putExtra("Cal", "%"); break;
                }
                 */
                intent.putExtra("Cal", rgCal.getCheckedRadioButtonId() ); // 이렇게 라디오 그룹값 넘기기**
                startActivityForResult(intent,0);
            }
        });

        /*
        btnNewActivity = findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNum1 = findViewById(R.id.edtNum1);
                edtNum2 = findViewById(R.id.edtNum2);

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent,0);
            }
        });
         */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //리턴되는 값이 존재 한다면
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("result",0);
            Toast.makeText(getApplicationContext(),"합계 : "+hap,Toast.LENGTH_SHORT).show();
        }
    }
}

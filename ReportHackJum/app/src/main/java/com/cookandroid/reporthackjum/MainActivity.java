package com.cookandroid.reporthackjum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch btnSwitch;
    LinearLayout mainLayout;

    EditText Test1, Test2, Assignment, Attendance, Name;
    Button btnCal, btnReset;

    String num1, num2, assignment, attendance; // 점수를 담을 String형 변수
    Double result; // 학점 계산 결과를 담을 Double형 변수

    View dialogView;
    ImageView ImgGrade;
    RadioButton Grade1, Grade2, Grade3;

    // dlg에 있는 TextView 아이디
    // TextView dlgText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    // 옵션 메뉴 선택에 따라 각각 처리하기
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemEnd : // 종료 선택시 앱 종료 : finish();
                finish();
                return true;

            case R.id.itemReset : // 초기화 선택시 입력사항 초기화
                Test1.setText(null);
                Test2.setText(null);
                Assignment.setText(null);
                Attendance.setText(null);
                Name.setText(null);

                Grade1.setChecked(false);
                Grade2.setChecked(false);
                Grade3.setChecked(false);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민정]간단 학점계산기_총정리");

        btnSwitch = (Switch)findViewById(R.id.btnSwitch);
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);

        Test1 = (EditText)findViewById(R.id.Test1);
        Test2 = (EditText)findViewById(R.id.Test2);
        Assignment = (EditText)findViewById(R.id.Assignment);
        Attendance = (EditText)findViewById(R.id.Attendance);

        Name = (EditText)findViewById(R.id.Name);
        Grade1 = (RadioButton)findViewById(R.id.grade1);
        Grade2 = (RadioButton)findViewById(R.id.grade2);
        Grade3 = (RadioButton)findViewById(R.id.grade3);

        btnCal = (Button)findViewById(R.id.btnCal);
        btnReset = (Button)findViewById(R.id.btnReset);

        ImgGrade = (ImageView)findViewById(R.id.ImgGrade);


        // 처음에는 안보이게
        mainLayout.setVisibility(View.INVISIBLE);

        // switch의 활성화/비활성화에 따라 화면이 나타나게/안보이게 하기
        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(btnSwitch.isChecked() == true){
                    mainLayout.setVisibility(View.VISIBLE);
                }
                else {
                    mainLayout.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogView = View.inflate(MainActivity.this, R.layout.dlg, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                ImgGrade = dialogView.findViewById(R.id.ImgGrade);
                dlg.setView(dialogView);
                dlg.setTitle("학점계산결과");

                // EditText에서 텍스트를 가져와 변수에 저장
                num1 = Test1.getText().toString();
                num2 = Test2.getText().toString();
                assignment = Assignment.getText().toString();
                attendance = Attendance.getText().toString();

                // 학점을 계산해 result 변수에 저장
                result = Integer.parseInt(num1)*0.3+Integer.parseInt(num2)*0.3+Integer.parseInt(assignment)*0.2+Integer.parseInt(attendance)*0.2;


                // 학년 라디오 버튼 체크 확인후 setMessage로 메세지 보이기
                if(Grade1.isChecked()){
                    dlg.setMessage("1학년 "+Name.getText()+"학생의 총점:"+result);
                }else if(Grade2.isChecked()){
                    dlg.setMessage("2학년 "+Name.getText()+"학생의 총점:"+result);
                }else{
                    dlg.setMessage("3학년 "+Name.getText()+"학생의 총점:"+result);
                };


                // 점수에 따른 등급별 사진 보이기
                if(result>= 90){
                    ImgGrade.setImageResource(R.drawable.alphabet_a);
                }
                else if(result>=80){
                    ImgGrade.setImageResource(R.drawable.alphabet_b);
                }
                else if(result>=70){
                    ImgGrade.setImageResource(R.drawable.alphabet_c);
                }
                else{
                    ImgGrade.setImageResource(R.drawable.alphabet_f);
                }
                dlg.setNegativeButton("확인",null);
                dlg.show();
            }
        });


        // 화면 하단의 초기화 버튼을 누를 시 입력사항 리셋
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Test1.setText(null);
                Test2.setText(null);
                Assignment.setText(null);
                Attendance.setText(null);
                Name.setText(null);

                Grade1.setChecked(false);
                Grade2.setChecked(false);
                Grade3.setChecked(false);
            }
        });


    }
}

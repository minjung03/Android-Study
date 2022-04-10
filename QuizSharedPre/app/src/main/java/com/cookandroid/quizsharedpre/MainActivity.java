package com.cookandroid.quizsharedpre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView tvNum, tvQiuz, tvOX;
    EditText edAns;
    Button btnIn, btnStart, btnNext;
    String[] quiz = {"캐나다의 수도는?","호주의 수도는?","케냐의 수도는?","스페인의 수도는?","독일의 수도는?"};
    String[] ans = {"오타와","캔버라","나이로비","스톡홀름","베를린"};
    int index = 0, ans_num = 0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [Pref 수도 퀴즈]");

        pref = getSharedPreferences("pref",0);
        editor = pref.edit();

        editor.putBoolean("savelogin",true);
        editor.putString("id","guest");
        editor.putString("pw","1234");
        editor.putInt("score",-1);
        editor.commit();

        tvNum = findViewById(R.id.tvNum);
        tvQiuz = findViewById(R.id.tvQiuz);
        tvOX = findViewById(R.id.tvOX);
        edAns = findViewById(R.id.edAns);
        btnIn = findViewById(R.id.btnIn);
        btnStart = findViewById(R.id.btnStart);
        btnNext = findViewById(R.id.btnNext);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dlgLoginView = (View) View.inflate(MainActivity.this, R.layout.logindlg, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("로그인");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setView(dlgLoginView);
                final EditText edID = dlgLoginView.findViewById(R.id.edID);
                final EditText edPW = dlgLoginView.findViewById(R.id.edPW);
                final CheckBox chkSave = dlgLoginView.findViewById(R.id.chkSave);

                if (pref.getBoolean("savelogin", false)) {
                    edID.setText(pref.getString("id", ""));
                    edPW.setText(pref.getString("pw", ""));
                    chkSave.setChecked(true);
                }

                chkSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            String id = edID.getText().toString();
                            String pw = edPW.getText().toString();
                            editor.putBoolean("savelogin", true);
                            editor.putString("id", id);
                            editor.putString("pw", pw);
                            editor.commit();
                        } else {
                            edID.setText("");
                            edPW.setText("");
                            editor.clear();
                            editor.commit();
                        }
                    }
                });
                dlg.setPositiveButton("로그인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String id = edID.getText().toString();
                        String pw = edPW.getText().toString();
                        editor.putBoolean("savelogin", true);
                        editor.putString("id", id);
                        editor.putString("pw", pw);
                        editor.commit();
                        if(id.equals(pref.getString("id","")) && pw.equals(pref.getString("pw",""))){
                            Toast.makeText(getApplicationContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "잘못 입력했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"guest로 로그인 합니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
                index=ans_num=0;
                tvNum.setText("문제 - "+(index+1));
                tvQiuz.setText(quiz[index]);
                btnIn.setEnabled(true);
                btnStart.setEnabled(false);
            }
        });

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edAns.getText().toString();
                if(s.equals("")) {
                    Toast.makeText(getApplicationContext(), "답을 먼저 적어주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s.equals(ans[index])) {
                        ans_num++;
                        tvOX.setText("O : 맞았습니다");
                    } else {
                        tvOX.setText("X : 틀렸습니다");
                    }
                    btnNext.setEnabled(true);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAns.setText("");
                btnNext.setEnabled(false);
                index++;

                if(index < ans.length) {
                    tvOX.setText("OX");
                    tvNum.setText("문제 - " + (index + 1));
                    tvQiuz.setText(quiz[index]);
                    edAns.setText("");
                }
                else {
                    tvOX.setText("OX");
                    tvNum.setText("문제 - Number");
                    tvQiuz.setText("문제");
                    btnIn.setEnabled(false);
                    btnStart.setEnabled(true);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("퀴즈 맞은 개수");
                    dlg.setMessage("총 맞은 개수 : "+ans_num+"\n점수를 저장하시겠습니까?");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            editor.putInt("score", ans_num);
                            editor.commit();
                            Toast.makeText(getApplicationContext(),"점수가 저장되었습니다.",Toast.LENGTH_SHORT).show();
                        }
                    });
                    dlg.setNegativeButton("취소", null);
                    dlg.show();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        AlertDialog.Builder dlg;

        switch (item.getItemId()) {


            case R.id.item_login: {
                View dlgLoginView = (View) View.inflate(MainActivity.this, R.layout.logindlg, null);
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("로그인 정보");
                dlg.setView(dlgLoginView);
                final EditText edID = dlgLoginView.findViewById(R.id.edID);
                final EditText edPW = dlgLoginView.findViewById(R.id.edPW);
                final CheckBox chkSave = dlgLoginView.findViewById(R.id.chkSave);

                if (pref.getBoolean("savelogin", false)) {
                    edID.setText(pref.getString("id", ""));
                    edPW.setText(pref.getString("pw", ""));
                    chkSave.setChecked(true);
                }
                chkSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if (b) {
                            String id = edID.getText().toString();
                            String pw = edPW.getText().toString();
                            editor.putBoolean("savelogin", true);
                            editor.putString("id", id);
                            editor.putString("pw", pw);
                            editor.commit();
                        } else {
                            edID.setText("");
                            edPW.setText("");
                            editor.clear();
                            editor.commit();
                        }
                    }
                });
                dlg.setPositiveButton("로그인 수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String id = edID.getText().toString();
                        String pw = edPW.getText().toString();
                        editor.putBoolean("savelogin", true);
                        editor.putString("id", id);
                        editor.putString("pw", pw);
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "로그인 정보 수정", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show();
                return true;
            }

            case R.id.item_score : {
               String id = pref.getString("id", "");
               int num = pref.getInt("score",-1);
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("ID : "+id);
                if(num != -1){
                    dlg.setMessage("맞은 개수 : "+num+"개");
                }
                else {
                    dlg.setMessage("저장된 점수가 없습니다.");
                }
                dlg.setPositiveButton("확인", null);
                dlg.show();
                return true;
            }

            case R.id.item_reStart: {
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("다시 풀기");
                dlg.setMessage("처음 부터 다시 풀어봅니다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        index = ans_num = 0;
                        tvNum.setText("문제 - " + (index + 1));
                        tvQiuz.setText(quiz[index]);
                        btnIn.setEnabled(true);
                        btnStart.setEnabled(false);
                        btnNext.setEnabled(false);
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
                return true;
            }

            case R.id.item_exit: {
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("종료");
                dlg.setMessage("프로그램을 종료합니다.");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
                return true;
            }
        }
        return false;
    }
}

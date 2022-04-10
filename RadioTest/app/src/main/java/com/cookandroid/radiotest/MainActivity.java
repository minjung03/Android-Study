package com.cookandroid.radiotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    RadioButton rdoCat, rdoDog, rdoRabbit, rdoHorse;
    ImageView imageView1;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민정] 라디오버튼 연습");

        btnConfirm = findViewById(R.id.btnConfirm);
        rdoCat = findViewById(R.id.imgCat);
        rdoDog = findViewById(R.id.imgDog);
        rdoRabbit = findViewById(R.id.imgRabbit);
        rdoHorse = findViewById(R.id.imgHorse);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                imageView1 = dialogView.findViewById(R.id.imageView1); //여기가 핵심, dialogView라고 안하면 메인XML파일에서 imageView1을 찾기때문에 에러가났다
                dlg.setView(dialogView);

                if(rdoCat.isChecked()){
                    imageView1.setImageResource(R.drawable.cat);
                    dlg.setTitle("고양이");
                } else if(rdoDog.isChecked()){
                    imageView1.setImageResource(R.drawable.dog);
                    dlg.setTitle("강아지");
                } else if(rdoRabbit.isChecked()){
                    imageView1.setImageResource(R.drawable.rabbit);
                    dlg.setTitle("토끼");
                } else if(rdoHorse.isChecked()){
                    imageView1.setImageResource(R.drawable.horse);
                    dlg.setTitle("말");
                }
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });

    }
}

/*
        btnDlgRdList = (Button)findViewById(R.id.btnDlgRdList);
        btnDlgRdList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] song = new String[] { "BTS", "박효신" , "MSG워너비" };
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 가수는?");

                // 스트링 라디오 버튼 목록(setSingleChoiceItems)으로 삽입
                dlg.setSingleChoiceItems(song, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "선택한 가수 : "+song[i], Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", null);

                dlg.show();
            }
        });
    }
}
 */

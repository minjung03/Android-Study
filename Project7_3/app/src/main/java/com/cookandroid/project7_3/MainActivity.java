package com.cookandroid.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Binder;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn,btnDlg1, btnDlgList,btnDlgRdList, btnDlgCkList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2102김민정_Toast 연습");

        btnDlgCkList = (Button)findViewById(R.id.btnDlgCkList);
        btnDlgCkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] song = new String[] { "BTS", "박효신" , "MSG워너비" };
                final boolean[] chkSong = new boolean[] { true, false, true };

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 가수는?");

                // 스트링 라디오 버튼 목록(setMultiChoiceItems)으로 삽입
                dlg.setMultiChoiceItems(song, chkSong, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        chkSong[i] = b;
                        String out = "";

                        for(int ind = 0; ind < song.length; ind++){
                            if(chkSong[ind] == true){
                                out = out +" "+song[ind];
                            }
                        }
                        if(out.equals("체크된 내용 : ")) Toast.makeText(getApplicationContext(), out+"선택이 아무 것도 없습니다.", Toast.LENGTH_LONG).show();
                        else Toast.makeText(getApplicationContext(), "체크된 내용 : "+out, Toast.LENGTH_LONG).show();
                    }
                });
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "닫기를 선택했습니다."+song[i], Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.show();


            }
        });

        btnDlgList = (Button)findViewById(R.id.btnDlgList);
        btnDlgList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] song = new String[] { "BTS", "박효신" , "MSG워너비" };
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("좋아하는 가수는?");

                // 스트링 배열 목록으로 삽입
                dlg.setItems(song, new DialogInterface.OnClickListener() {  // 목록을 선택했을 때
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { // i 변수가 선택한 item의 인덱스!
                        Toast.makeText(getApplicationContext(), "선택한 가수 : "+song[i], Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "닫기를 선택했습니다."+song[i], Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.show();
            }
        });

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

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast tMsg = Toast.makeText(MainActivity.this, "토스트 연습", Toast.LENGTH_SHORT);

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                tMsg.show();
            }
        });

        btnDlg1 = (Button)findViewById(R.id.btnDlg1);
        btnDlg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목입니다.");
                dlg.setMessage("[김민정] 내용입니다.");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("확인", null);

                dlg.show();
            }
        });
    }
}

package com.cookandroid.project7_3_dlgview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtName, txtEmail, toastTxt, dlgTxtId;
    EditText dlgEdName, dlgEdEmail , edId;
    Button btn;

    View dlgView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민정] Dlg setView 연습");

        txtName = (TextView)findViewById(R.id.txtName);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        btn = (Button)findViewById(R.id.btn);
        edId = (EditText)findViewById(R.id.edId);
        // 다른 것들은 메모리 할당을 아직 안해서 findViewById 못함

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dlgView = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);   // 메모리 할당 (객체 생성)
                dlgTxtId = (TextView)findViewById(R.id.dlgTxtId);
                dlgTxtId.setText(edId.getText().toString());

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dlgView에서 입력한 Edit 내용을 Main xml의 Text에 출력

                        dlgEdName = (EditText)dlgView.findViewById(R.id.dlgEdName);
                        dlgEdEmail = (EditText)dlgView.findViewById(R.id.dlgEdEmail);
                        // dlgView에 있는 위젯을 가져와야하니 꼭 이렇게 적어야 한다. (해당하는 대상을 잘 체크해야 함)

                        txtName.setText(dlgEdName.getText().toString());
                        txtEmail.setText(dlgEdEmail.getText().toString());
                    }
                });

                // 취소 버튼을 눌렀을 때 Toast 출력!
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toastView = (View)View.inflate(MainActivity.this, R.layout.toast1, null);
                        Toast toast = new Toast(MainActivity.this);

                        toastTxt = (TextView)toastView.findViewById(R.id.toastTxt);
                        toastTxt.setText("취소되었습니다.");

                        toast.setView(toastView);
                        toast.show();


                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());

                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                        toast.show();

                    }
                });

                // 다이얼로그 만들고 꼭 show() 해줘야한다!
                dlg.show();
            }
        });
    }
}

package com.cookandroid.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnColor, btnChange, btnGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[2102김민정] 컨텍스트 메뉴");

        btnColor = (Button)findViewById(R.id.btnColor);
        btnChange = (Button)findViewById(R.id.btnChange);

        // 컨텍스트 메뉴로 위젯 등록하기
        registerForContextMenu(btnColor);
        registerForContextMenu(btnChange);

        // 팝업 메뉴 부분
        // 팝업메뉴(버튼 클릭시 메뉴를 팝업시키기/PopupMenu 클래스 사용)
        btnGrade = (Button)findViewById(R.id.btnGrade);
        btnGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // 1. 팝업 메뉴 생성해서 처리
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.pop, p.getMenu());

                // 2. 메뉴 아이템 선택 처리
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.item1 :
                                Toast.makeText(getApplicationContext(), "1학년 선택",Toast.LENGTH_LONG).show();
                                return true;

                            case R.id.item2 :
                                Toast.makeText(getApplicationContext(), "2학년 선택",Toast.LENGTH_LONG).show();
                                return true;

                            case R.id.item3 :
                                Toast.makeText(getApplicationContext(), "3학년 선택",Toast.LENGTH_LONG).show();
                                return true;
                        }
                        return false;
                    }
                });
                // **반드시 해야하는 것!!**
                p.show(); // 3. 팝업 메뉴 화면에 출력하기
            }
        });
    }

    // 여기에서 컨텍스트 메뉴 create
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        // 무슨 버튼이 롱클릭 됬는지 체크
        if(v==btnColor){
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }
        if(v==btnChange){
            menu.setHeaderTitle("버튼 변경");
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }


    // 컨텍스트 메뉴 item 선택했을 때 처리
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemRed : btnColor.setBackgroundColor(Color.RED); return true;
            case R.id.itemGreen : btnColor.setBackgroundColor(Color.GREEN); return true;
            case R.id.itemWhite : btnColor.setBackgroundColor(Color.parseColor("#DDDDDD")); return true;
            case R.id.itemRotate : btnChange.setRotation(45); return true;
            case R.id.itemSize : btnChange.setScaleX(2); return true;
            case R.id.itemReturn : btnChange.setRotation(0); btnChange.setScaleX(1); return true; // 원상복귀
        }

        return super.onContextItemSelected(item);
    }

    // 옵션메뉴를 하나 넣어보자.


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.pop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item1 :
                Toast.makeText(getApplicationContext(), "1학년 선택",Toast.LENGTH_LONG).show();
                return true;

            case R.id.item2 :
                Toast.makeText(getApplicationContext(), "2학년 선택",Toast.LENGTH_LONG).show();
                return true;

            case R.id.item3 :
                Toast.makeText(getApplicationContext(), "3학년 선택",Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}

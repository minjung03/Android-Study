package com.cookandroid.optionmenutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //LinearLayout baseLayout;
    //Button btn;

    EditText angle;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[2102김민정]옵션메뉴");

        angle = (EditText)findViewById(R.id.angle);
        img = (ImageView)findViewById(R.id.img);

        /*baseLayout = (LinearLayout)findViewById(R.id.BaseLayout);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "옵션메뉴 연습",Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemRotate :
                img.setRotation(Float.parseFloat(angle.getText().toString())); return true;
            case R.id.Hanlla :
                img.setImageResource(R.drawable.jeju1);  return true;
            case R.id.Chujado :
                img.setImageResource(R.drawable.jeju2);  return true;
            case R.id.Beomseom :
                img.setImageResource(R.drawable.jeju3);  return true;

        }
        /*switch (item.getItemId()){
            case R.id.itemRed :
                baseLayout.setBackgroundColor(Color.RED); return true;

            case R.id.itemGreen :
                baseLayout.setBackgroundColor(Color.GREEN); return true;

            case R.id.itemGray :
                // parseColor 사용해서 rgb를 줄 수도 있음!
                baseLayout.setBackgroundColor(Color.parseColor("#eeeeee")); return true;

            case R.id.subRotate:
                btn.setRotation(45); return true; //45도 회전

            case R.id.subSize :
                btn.setScaleX(2); return true; // 2배 확대

            case R.id.subReturn :
                btn.setRotation(0); // 원상복귀
                btn.setScaleX(1); return true;
        }*/
        return false;
    }
}

package com.cookandroid.project10_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends Activity {

    Button btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        setTitle("김민정 [버튼C]");

        btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 이 두가지는 잘 사용하니 알아두기!!! FLAG_ACTIVITY_SINGLE_TOP / FLAG_ACTIVITY_CLEAR_TOP

                Intent inc = new Intent(getApplicationContext(),ThirdActivity.class);
                inc.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // FLAG_ACTIVITY_SINGLE_TOP
                // 호출되는 Activtiy가 최상위에 있을 경우(자기자신을 다시 호출할 때)
                // 해당  Activtiy를 다시 생성하지 않고, 있던  Activtiy를 다시 재사용!

                startActivity(inc);

                /*
                Intent ina = new Intent(getApplicationContext(), MainActivity.class);
                ina.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // FLAG_ACTIVITY_CLEAR_TOP
                // A->B->C 에서 A호출하면 task에 모든 A,B가 pop되고 호출한 A가 root로 push
                // 해당 task에 있는 모든 activity를 pop 시키고 해당 activtiy가 root activity로 task에 push

                startActivity(ina);
                finish();
                 */
            }
        });


    }

}

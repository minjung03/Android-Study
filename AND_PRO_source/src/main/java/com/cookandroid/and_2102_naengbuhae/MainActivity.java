package com.cookandroid.and_2102_naengbuhae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    ListView date_ListView;
    DateListAdapter date_list_adapter;
    ArrayList<DateList> mArray;
    DateList dateitem;

    String[] setDate = {"3일", "5일"};
    String[] location = {"냉장 오른쪽 위 선반", "냉동실 아래칸"};
    String[] title = {"참치마요 삼각김밥", "맛있는 우유"};
    String[] viewDate = {"2021.10.29 까지", "2021.11.23 까지"};
    String[] enroll = {"2021.9.10 등록", "2021.10.23 등록"};
    */

    Button btn_ShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
         setContentView(R.layout.activity_main);

         /*
        date_ListView = findViewById(R.id.main_list_date);
        mArray = new ArrayList<DateList>();

        for(int i=0; i<setDate.length; i++){
            dateitem = new DateList(setDate[i], location[i], title[i], viewDate[i], enroll[i]);
            mArray.add(dateitem); //각 아이템을 Movie 클래스로 사용, Array에 add
        }
        //Movie 어댑터에 ArrayList로 세팅하고 ListView와 연결
        date_list_adapter = new DateListAdapter(this, mArray);
        date_ListView.setAdapter(date_list_adapter);
        */

        btn_ShowList=findViewById(R.id.btn_ShowList);

        btn_ShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                startActivity(intent);

            }
        });

    }

}

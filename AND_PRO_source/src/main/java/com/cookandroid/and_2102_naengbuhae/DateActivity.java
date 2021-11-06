package com.cookandroid.and_2102_naengbuhae;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DateActivity  extends AppCompatActivity {

    ListView date_ListView;
    DateListAdapter date_list_adapter;
    ArrayList<DateList> mArray;
    DateList dateitem;

    /*
    String[] setDate = {"3일", "5일", "12일", "31일"};
    String[] location = {"냉장실 오른쪽 위 선반", "냉동실 아래칸","냉장실 왼쪽 문",""};
    String[] title = {"참치마요 삼각김밥", "맛있는 우유", "계란","소고기"};
    String[] viewDate = {"2021.10.29 까지", "2021.11.23 까지","2021.12.10 까지","2021.10.11 까지"};
    String[] enroll = {"2021.9.10 등록", "2021.10.23 등록","2021.10.31 등록","2021.9.2 등록"};
   */

    String[] setDate = {"3일"};
    String[] location = {"냉장실 오른쪽 위 선반"};
    String[] title = {"참치마요 삼각김밥"};
    String[] viewDate = {"2021.10.29 까지"};
    String[] enroll = {"2021.9.10 등록"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_date_list);

        date_ListView = findViewById(R.id.main_list_date);
        mArray = new ArrayList<DateList>();

        for(int i=0; i<setDate.length; i++){
            dateitem = new DateList(setDate[i], location[i], title[i], viewDate[i], enroll[i]);
            mArray.add(dateitem); //각 아이템을 Date 클래스로 사용, Array에 add
        }
        //Movie 어댑터에 ArrayList로 세팅하고 ListView와 연결
        date_list_adapter = new DateListAdapter(this, mArray);
        date_ListView.setAdapter(date_list_adapter);

    }
}

package com.cookandroid.project11_2_customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mList;
    MovieAdapter mAdapter;
    ArrayList<Movie> mArray;
    Movie mitem;

    Integer[] posters = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,};

    String[] titles = {"써니", "완득이","괴물","라디오 스타","비열한 거리","왕의 남자","아일랜드",
            "웰컴투 동막골","헬보이","Back to Future"};

    String[] genre = {"DRAMA", "DRAMA", "SRILLER", "DRAMA", "DRAMA", "DRAMA", "SRILLER", "DRAMA",
            "SRILLER","DRAMA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [CustomListView 실습]");

        mList = findViewById(R.id.listView1);
        mArray = new ArrayList<Movie>();

        for(int i=0; i<posters.length; i++){
            mitem = new Movie(ContextCompat.getDrawable(this, posters[i]), titles[i], genre[i]);
            mArray.add(mitem); //각 아이템을 Movie 클래스로 사용, Array에 add
        }

        //Movie 어댑터에 ArrayList로 세팅하고 ListView와 연결
        mAdapter = new MovieAdapter(this, mArray);
        mList.setAdapter(mAdapter);

        // 아이템을 클릭하면 아이템의 내용을 토스트로 출력
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Movie item = (Movie) mList.getItemAtPosition(i);
                String title = item.getTitle();
                Toast.makeText(getApplicationContext(),title,Toast.LENGTH_SHORT).show();
            }
        });
    }

}

package com.cookandroid.project11_2_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    MovieAdpter adpter;

    // 영화 포스터 그림 파일의 ID를 배열로 지정
    Integer[] posters = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,};
    String[] titles = {"써니", "완득이","괴물","라디오 스타","비열한 거리","왕의 남자","아일랜드",
            "웰컴투 동막골","헬보이","Back to Future"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [GridView 실습]");

        gridView = findViewById(R.id.gridView);
        adpter = new MovieAdpter(posters);
        gridView.setAdapter(adpter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 각 영화를 클릭하면 대화상자가 나오고 영화 포스터의 원래 크기가 보이도록 수정
                View v = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                ImageView iv = v.findViewById(R.id.imgDialog);
                iv.setImageResource(posters[i]);

                dlg.setTitle(titles[i]);
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setView(v);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
    }
}

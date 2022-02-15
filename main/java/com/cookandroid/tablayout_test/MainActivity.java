package com.cookandroid.tablayout_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("[2102김민정]TabLayout");

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        // FragmentAdapter 생성자 (FragmentAdapter 객체)
        adapter=new FragmentAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter); // 뷰페이저와 어댑터 연결
        tabLayout.setupWithViewPager(viewPager); // 뷰페이저와 탭 레이아웃을 연동
        tabLayout.getTabAt(0).setText("계산기"); // 탭이름 생성
        tabLayout.getTabAt(1).setText("스톱워치"); // 탭이름 생성

        // 탭에 아이콘 넣기
        tabLayout.getTabAt(0).setIcon(R.drawable.calc2);
        tabLayout.getTabAt(1).setIcon(R.drawable.weight2);

        // 탭 이벤트 처리(동작 처리)
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { // 탭이 선택 되었을때

                if(tab.getPosition()==0){ // 0번 인덱스이면
                    Toast.makeText(getApplicationContext(), "계산기", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "스톱워치", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {   } // 탭이 해제되었을 때

            @Override
            public void onTabReselected(TabLayout.Tab tab) {  } // 탭이 재선택 되었을 때

        });

    }
}

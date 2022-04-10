package com.cookandroid.protabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2102김민정[음악 플레이어]");

        TabHost tabHost = getTabHost(); //xml에 탭호슨 id 가져오기

        // Song 탭 위젯 생성 후, 탭에 등록
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong);  // Song 탭을 선택했을때 보여질 내용 연결작업
        tabHost.addTab(tabSpecSong);

        // Artist 탭 위젯 생성 후, 탭에 등록
        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("Artist").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist);  // Artist 탭을 선택했을때 보여질 내용 연결작업
        tabHost.addTab(tabSpecArtist);

        // Album 탭 위젯 생성 후, 탭에 등록
        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("Album").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum);  // Album 탭을 선택했을때 보여질 내용 연결작업
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0); // 몇번째 탭부터 보여줄래? 음악별부터!
    }
}

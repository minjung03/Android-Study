package com.cookandroid.project11_2_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] posterId = {R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov15, R.drawable.mov17,
            R.drawable.mov18, R.drawable.mov19, R.drawable.mov20, R.drawable.mov21, R.drawable.mov22 };

    String[] MvName =  {"여인의 향기","쥬라기 공원","포레스트 검프","혹성탈출","내 이름은 칸",
            "해리포터:이제 모든 것이 끝난다","마더","킹콩을 들다","쿵푸팬더2","짱구는 못말려"};

    ImageView poster;

    Spinner spMovie;
    ArrayAdapter<String> adapter;

    /* 갤러리 예제
    Gallery gallery;
    View toastView;
    TextView toastText;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [Gallery 실습]");

        // 갤러리 예제
        // gallery = findViewById(R.id.gallery);
        poster = findViewById(R.id.ivPoster);

        MyGalleryAdapter galAdapter = new MyGalleryAdapter(this, posterId);

        /* 갤러리 예제
        gallery.setAdapter(galAdapter);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                poster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                poster.setImageResource(posterId[i]);

                Toast toast=new Toast(MainActivity.this);
                toastView=(View)View.inflate(MainActivity.this, R.layout.toast,null);
                toastText=(TextView)toastView.findViewById(R.id.Ttext);
                toastText.setText(MvName[i]);
                toast.setView(toastView) ;
                toast.show();


               // Toast.makeText(getApplicationContext(),MvName[i],Toast.LENGTH_SHORT).show();
            }
        });
         */


        spMovie = findViewById(R.id.spMovie);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, MvName);
        spMovie.setAdapter(adapter);

        spMovie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                poster.setImageResource(posterId[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

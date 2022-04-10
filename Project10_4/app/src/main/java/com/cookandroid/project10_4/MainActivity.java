package com.cookandroid.project10_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnWeb, btnGoogle, btnSearch, btnSms, btnPhoto , btnContact, btnEmail, btnFinish;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트","onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트","onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트","onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티 테스트","onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트","onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트","onPause()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [암시적 인텐트]");

        android.util.Log.i("액티비티 테스트","onCreate()");

        btnDial = findViewById(R.id.btnDial);
        btnWeb = findViewById(R.id.btnWeb);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnSearch = findViewById(R.id.btnSearch);
        btnSms = findViewById(R.id.btnSms);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnContact = findViewById(R.id.btnContact);
        btnEmail = findViewById(R.id.btnEmail);
        btnFinish = findViewById(R.id.btnFinish);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.hanbit.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.co.kr/maps/@37.053745,125.6553969,5z?hl=ko");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body","안녕하세요");
                intent.setData(Uri.parse("smsto:"+Uri.encode("010-123404567")));
                startActivity(intent);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://contacts/people/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:"+"birchTree@naver.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body","Hello");
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}

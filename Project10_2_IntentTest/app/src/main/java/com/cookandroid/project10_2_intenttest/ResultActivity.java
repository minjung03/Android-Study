package com.cookandroid.project10_2_intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[]= {R.id.bar1,R.id.bar2, R.id.bar3,R.id.bar4,R.id.bar5,R.id.bar6,R.id.bar7,R.id.bar8,R.id.bar9 };
        Integer imageFiledId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
                R.drawable.pic6,R.drawable.pic7, R.drawable.pic8,R.drawable.pic9};

        for(int i=0; i<voteResult.length; i++){
            tv[i] = findViewById(tvID[i]);
            rbar[i]= findViewById(rbarID[i]);
        }

        for(int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float)voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}

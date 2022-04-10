package com.cookandroid.graphictest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static int Line = 1, CIRCE = 2 , REC = 3;
    static int curShape = Line;
    static int curColor = Color.DKGRAY; // 색을 저장하는 변수 선언 (int 타입 가능!!)
    // 기본으로 다크그레이 색상 지정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("김민정 [간단 그림판]");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemLine :
                curShape = Line;
                return true;

            case R.id.itemCircle :
                curShape = CIRCE;
                return true;

            case R.id.itemRes :
                curShape = REC;
                return true;

            case R.id.itemBlue :
                curColor = Color.BLUE;
                return true;

            case R.id.itemGreen :
                curColor = Color.GREEN;
                return true;

            case R.id.itemRed :
                curColor = Color.RED;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;

                case MotionEvent.ACTION_MOVE:

                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);


            switch (curShape){
                case Line :
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;

                case CIRCE:
                    int radius = (int)Math.sqrt(Math.pow(stopX-startX,2) + Math.pow(stopY-startY,2));
                    canvas.drawCircle(startX, startX, radius, paint);
                    break;

                case REC :
                    canvas.drawRect(startX, startY, stopX, stopY, paint);
                    break;
            }

        }
    }

}

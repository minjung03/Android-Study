package com.cookandroid.graphic_image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ibzoom_in, ibzoom_out, ibRotate, ibBright, ibDark, ibGray, ibBlur, ibEmbo;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0, color = 1, satur = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [미니 포토샵]");

        LinearLayout picLayout = findViewById(R.id.picLayout);
        graphicView = (MyGraphicView)new MyGraphicView(this);
        picLayout.addView(graphicView);
        clickIcons();
    }

    private static class MyGraphicView extends View{
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() /2;

            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);
            Paint paint = new Paint();

            float[] array = { color, 0,0,0,0,0,color,0,0,0,0,0,color,0,0,0,0,0,1,0};
            ColorMatrix cm = new ColorMatrix(array);

            if(satur == 0) cm.setSaturation(satur);
            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);

            int picX = (this.getWidth() - picture.getWidth()) /2;
            int picY = (this.getHeight() - picture.getHeight()) /2;

            BlurMaskFilter bMask;
            bMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
            paint.setMaskFilter(bMask);

            canvas.drawBitmap(picture, picX, picY, paint);
            picture.recycle();
        }
    }

    private void clickIcons(){

        ibzoom_in = findViewById(R.id.ibZoomin);
        ibzoom_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();
            }
        });

        ibzoom_out = findViewById(R.id.ibZoomout);
        ibzoom_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();
            }
        });

        ibRotate = findViewById(R.id.ibRotate);
        ibRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle+20;
                graphicView.invalidate();
            }
        });

        ibBright = findViewById(R.id.ibBright);
        ibBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color+0.2f;
                graphicView.invalidate();
            }
        });

        ibDark = findViewById(R.id.ibDark);
        ibDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });


        ibGray = findViewById(R.id.ibGray);
        ibGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(satur == 0) satur = 1;
                else  satur = 0;
                graphicView.invalidate();
            }
        });

    }
}

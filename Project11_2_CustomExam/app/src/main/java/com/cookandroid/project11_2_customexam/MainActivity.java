package com.cookandroid.project11_2_customexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView pList;
    PhoneAdapter pAdapter;
    ArrayList<Phone> pArray;
    Phone pitem;

    View toastView;
    TextView toastText;
    ImageView toastimg;

    Integer[] Pimg = {R.drawable.ph1, R.drawable.ph2, R.drawable.ph3, R.drawable.ph4, R.drawable.ph5, R.drawable.ph6,
            R.drawable.ph7, R.drawable.ph8 ,R.drawable.ph9,R.drawable.ph10};

    String[] title = {"Galaxy A12", "Galaxy A32", "Galaxy A42", "Galaxy M12", "Galaxy 노트20", "Galaxy 퀸텀2",
    "Galaxy S21", "Galaxy S21+", "Galaxy Z 플립", "Galaxy Z 플립2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [CustomListView 실습]");

        pList = findViewById(R.id.listView);
        pArray = new ArrayList<Phone>();

        for(int i=0; i<Pimg.length; i++){
            pitem = new Phone(ContextCompat.getDrawable(this, Pimg[i]), title[i]);
            pArray.add(pitem);
        }

        pAdapter = new PhoneAdapter(this, pArray);
        pList.setAdapter(pAdapter);

        pList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Phone item = (Phone) pList.getItemAtPosition(i);
                String titles = item.getPName();

                Toast toast=new Toast(MainActivity.this);
                toastView = (View)View.inflate(MainActivity.this, R.layout.toast,null);

                toastimg = (ImageView)toastView.findViewById(R.id.toastimg);
                toastText = (TextView)toastView.findViewById(R.id.toastText);
                toastText.setText(title[i]);
                toast.setView(toastView) ;
                toast.setGravity(Gravity.CENTER, 5, 30);
                toast.show();

                setTitle(title[i]);
            }
        });

    }
}

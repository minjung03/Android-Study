package com.cookandroid.project6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* --activity_main.xml 코드--
    Chronometer chrono;
    Button btnStart, btnStop;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView txtResult; */

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    DatePicker dpicker;
    TimePicker timePicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chronometer_test2);
        setTitle("2102_김민정[간단예약]");

        chrono = (Chronometer) findViewById(R.id.ch1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        dpicker=(DatePicker)findViewById(R.id.datePicker1);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        timePicker.setVisibility(View.INVISIBLE);
        dpicker.setVisibility(View.INVISIBLE);
        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                dpicker.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                dpicker.setVisibility(View.INVISIBLE);
            }
        });
        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(dpicker.getYear()));
                tvMonth.setText(Integer.toString(1+dpicker.getMonth()));
                tvDay.setText(Integer.toString(dpicker.getDayOfMonth()));
                tvHour.setText(Integer.toString(timePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(timePicker.getCurrentMinute()));
                return false;
            }
        });



        /* --activity_main.xml 코드--
        chrono = (Chronometer)findViewById(R.id.chrono1);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        rdoCal = (RadioButton)findViewById(R.id.rodCal);
        rdoTime = (RadioButton)findViewById(R.id.rodTime);
        calView = (CalendarView)findViewById(R.id.calender);
        tPicker = (TimePicker)findViewById(R.id.timePick);
        txtResult = (TextView)findViewById(R.id.txtResult);

        // 캘린더, 타임피커가 처음에는 안보이게, 선택을 하면 보이게
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime()); //시스템에 있는 시간을 이용해서 카운터 세기(속도)
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                String str = "예약됨";
                str = sYear+"년 "+sMonth+"월 "+sDay+"일 "+tPicker.getCurrentHour()+"시 "+tPicker.getCurrentMinute()+"분 "+str;
                txtResult.setText(str);
            }
        });
        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) { // int i, int i1 으로 되어있던 변수 이름을 바꿔줌! 알기쉽게
                sYear = year;
                sMonth = month + 1; // 기본으로 0부터 시작하기 때문에 1을 더해주어야 한다!
                sDay = day;
            }
        });


        예시)
        // 롱클릭 코딩(길게 누르면 보인다!)
        btnStart.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(getApplicationContext(), "롱클릭",Toast.LENGTH_LONG).show();
                return true;
            }
        });*/



    }
}

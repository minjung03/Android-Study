package com.cookandroid.moviedb_0902;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayMovie extends AppCompatActivity {

    private DBHelper mydb;
    EditText name;
    EditText director;
    EditText year;
    EditText nation;
    Spinner rating;
    ImageView imgBack;
    int id = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_movie);

        name = findViewById(R.id.editTextName);
        director = findViewById(R.id.editTextDirector);
        year = findViewById(R.id.editTextYear);
        nation = findViewById(R.id.editTextNation);
        rating = findViewById(R.id.editTextRating);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Bundle은 데이터를 여러개 묶어놓은 묶음
        // 여러 타입의 key : value 형태를 묶을 수 있는 타입?
        mydb = new DBHelper(this);
        rating.setSelection(4); // 기본 평점을 5로 잡음
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            int Value = extras.getInt("id");
            if(Value > 0) {
                Cursor rs = mydb.getData(Value);
                id = Value;
                rs.moveToFirst();

                String n = rs.getString(rs.getColumnIndex(DBHelper.MOVIES_COLUMN_NAME));
                String d = rs.getString(rs.getColumnIndex(DBHelper.MOVIES_COLUMN_DIRECTOR));
                String y = rs.getString(rs.getColumnIndex(DBHelper.MOVIES_COLUMN_YEAR));
                String na = rs.getString(rs.getColumnIndex(DBHelper.MOVIES_COLUMN_NATION));
                String r = rs.getString(rs.getColumnIndex(DBHelper.MOVIES_COLUMN_RATING));
                if (!rs.isClosed()) {
                    rs.close();
                }

                Button b = findViewById(R.id.button1);
                b.setVisibility(View.GONE);

                name.setText((CharSequence) n);
                director.setText((CharSequence) d);
                year.setText((CharSequence) y);
                nation.setText((CharSequence) na);

                switch (r) {
                    case "1": rating.setSelection(0); break;
                    case "2": rating.setSelection(1); break;
                    case "3": rating.setSelection(2); break;
                    case "4": rating.setSelection(3); break;
                    case "5": rating.setSelection(4); break;
                    default:  rating.setSelection(4);
                }
            }
        }
        else {
            Button b2 = findViewById(R.id.button2);
            b2.setVisibility(View.GONE);
            Button b3 = findViewById(R.id.button3);
            b2.setVisibility(View.GONE);
        }
    }

    public void insert(View view){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int Value = extras.getInt("id");
            if(Value > 0){
                if(mydb.updateMovie(id, name.getText().toString(), director.getText().toString(), year.getText().toString(),
                        nation.getText().toString(), rating.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),"수정되었음", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "수정되지 않았음", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                if(mydb.insertMovie(name.getText().toString(), director.getText().toString(), year.getText().toString(),
                        nation.getText().toString(), rating.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(),"추가되었음", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"추가되지 않았음", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        }
    }

    public void delete(View view){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int Value = extras.getInt("id");
            if(Value > 0){
                mydb.deleteMovie(id);
                Toast.makeText(getApplicationContext(), "삭제되었음", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), "삭제되지 않았음", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void edit(View view){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int Value = extras.getInt("id");
            if(Value > 0){
                if(mydb.updateMovie(id, name.getText().toString(), director.getText().toString(), year.getText().toString(),
                        nation.getText().toString(), rating.getSelectedItem().toString())) {
                    Toast.makeText(getApplicationContext(), "수정되었음", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "수정되지 않았음", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

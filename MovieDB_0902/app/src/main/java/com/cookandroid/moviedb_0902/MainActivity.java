package com.cookandroid.moviedb_0902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
    DBHelper mydb;
    ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민정] Movie_DB");

        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllMovies();
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_list);
        myListView = findViewById(R.id.listView1);
        myListView.setAdapter(mAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg4) {

                String item = (String) ((ListView) parent).getItemAtPosition(position);
                String[] strArray = item.split(" ");
                int id = Integer.parseInt(strArray[0]);
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id);
                Intent intent = new Intent(getApplicationContext(), DisplayMovie.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.clear();
        mAdapter.addAll(mydb.getAllMovies());
        mAdapter.notifyDataSetChanged();
    }

    public void onClick(View target){
        Bundle bundle = new Bundle();
        bundle.putInt("id", 0);
        Intent intent = new Intent(getApplicationContext(), DisplayMovie.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

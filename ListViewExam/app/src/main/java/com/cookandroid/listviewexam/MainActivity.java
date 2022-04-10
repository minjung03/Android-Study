package com.cookandroid.listviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnSelect , btnCancel, btnAllSel;
    ArrayAdapter<String> adapter;
    String[] str = {"사과", "배", "귤", "바나나", "포도", "오렌지"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[김민정] ListView");

        listView = findViewById(R.id.listView);
        btnSelect = findViewById(R.id.btnSelect);
        btnCancel = findViewById(R.id.btnCancel);
        btnAllSel = findViewById(R.id.btnAllSel);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, str);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList<String> selectedItems = new ArrayList<>();
                SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
                for(int i=0; i<listView.getCount(); i++){
                    if(checkedItemPositions.get(i)) {
                        selectedItems.add(listView.getItemAtPosition(i).toString());
                    }
                }
                String str = new String();
                for(int i=0; i<selectedItems.size(); i++){
                    str += selectedItems.get(i)+" ";
                }
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        btnAllSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<listView.getCount(); i++){
                    listView.setItemChecked(i, true);
                }
            }
        });

    }
}

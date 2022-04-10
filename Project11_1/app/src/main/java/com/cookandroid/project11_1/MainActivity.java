package com.cookandroid.project11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtAdd;
    Button btnAdd, btnDelete;
    ListView list;
    ArrayList<String> midList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [리스트뷰 추가/삭제]");

        edtAdd = findViewById(R.id.edtAdd);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        list = findViewById(R.id.listView1);

        midList = new ArrayList<String>();
        /*
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, midList);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
         */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, midList);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                midList.add(edtAdd.getText().toString());
                adapter.notifyDataSetChanged(); // 데이터값이 변경되었음을 adpter에게 알려줌
                edtAdd.setText("");
                edtAdd.setHint("구입할 상품을 입력하세요");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                int pos;
                pos = list.getCheckedItemPosition(); //체크한 아이템 번호를 가져옴
                if(pos != ListView.INVALID_POSITION){ // 유효한 값일 경우
                    midList.remove(pos);
                    Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    list.clearChoices();
                    adapter.notifyDataSetChanged();
                }
                 */

                SparseBooleanArray sbArray = list.getCheckedItemPositions();
                if(sbArray.size() != 0){
                    for(int i=list.getCount()-1; i>=0; i--){
                        if(sbArray.get(i)){
                            midList.remove(i);
                        }
                    }
                    list.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "선택한 항목명 : "+midList.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

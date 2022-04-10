package com.cookandroid.martmall_0826;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BasketList extends AppCompatActivity {

    Button btnBuyOk, btnBuyListCancel, btnAllSelect, btnSelectCancel, btnDel;
    ListView basketList;
    ArrayAdapter<String> mAdapter;

    static ArrayList<String> goodsList = new ArrayList<String>();
    static ArrayList<String> goodtitle = new ArrayList<String>();
    static ArrayList<Integer> goodprice = new ArrayList<Integer>();
    static ArrayList<Integer> goodnum = new ArrayList<Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_list);

        basketList = findViewById(R.id.basketList);
        btnBuyOk = findViewById(R.id.btnBuyOk);
        btnBuyListCancel = findViewById(R.id.btnBuyListCancel);
        btnAllSelect = findViewById(R.id.btnAllSelect);
        btnSelectCancel = findViewById(R.id.btnSelectCancel);
        btnDel = findViewById(R.id.btnDel);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, goodsList);
        basketList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        basketList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        btnBuyOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray sbArray = basketList.getCheckedItemPositions();
                if(sbArray.size() != 0){
                    // final ArrayList<String> selectedItems = new ArrayList<>(); // 선택한 항목을 저장할 배열
                    int sum = 0;
                    String str = "";

                    for(int i=basketList.getCount()-1; i >= 0; i--){
                        if(sbArray.get(i)){
                            str += goodtitle.get(i); // selectedItems.add(goodtitle.get(i));
                            sum += goodprice.get(i) * goodnum.get(i); // 총 합 계산

                            // 계산된 물건 삭제
                            goodsList.remove(i);
                            goodtitle.remove(i);
                            goodprice.remove(i);
                            goodnum.remove(i);
                        }
                    }
                    str += "\n총 결제 금액 = "+sum+"원";
                    mAdapter.notifyDataSetChanged();

                    // String str = ""; for(int i=0; i<selectedItems.size(); i++) str+=selectedItems.get(i)+"";
                    AlertDialog.Builder dlg = new AlertDialog.Builder(BasketList.this); // 다이얼로그에 계산된 금액 출력
                    dlg.setTitle("주문 목록");
                    dlg.setIcon(R.mipmap.ic_launcher_round);
                    dlg.setMessage(str);
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    dlg.show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "주문할 물건을 선택해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBuyListCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "주문 취소", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SparseBooleanArray sbArray = basketList.getCheckedItemPositions();
                if(sbArray.size() != 0){

                    for(int i = basketList.getCount()-1; i >=  0 ; i--){
                        if(sbArray.get(i)){
                            goodsList.remove(i);
                            goodtitle.remove(i);
                            goodprice.remove(i);
                            goodnum.remove(i);
                        }
                        basketList.clearChoices();
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        btnAllSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<basketList.getCount(); i++){
                    basketList.setItemChecked(i, true);
                }
                mAdapter.notifyDataSetChanged();
            }
        });

        btnSelectCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basketList.clearChoices();
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}

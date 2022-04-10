package com.cookandroid.projectdb_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtGName, edtGNumber;
    TextView txtGNameResult, txtGNumResult;
    Button btnClear, btnInsert, btnSelect, btnUpdate, btnDelete;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("김민정 [SQLite 실습]");

        edtGName = findViewById(R.id.edtGName);
        edtGNumber = findViewById(R.id.edtGNumber);
        txtGNameResult = findViewById(R.id.txtGNameResult);
        txtGNumResult = findViewById(R.id.txtGNumResult);

        btnClear = findViewById(R.id.btnClear);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        myHelper = new MyDBHelper(this);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + edtGName.getText().toString() + "', " + edtGNumber.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력되었습니다.", Toast.LENGTH_SHORT).show();

                }catch (Exception e){

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"입력에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM groupTBL", null);

                String strNames = "그룹명" + "\n" + "________" + "\n";
                String strNumbers = "인원수" + "\n" + "________" + "\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\n";
                    strNumbers += cursor.getString(1) + "\n";
                }

                txtGNameResult.setText(strNames);
                txtGNumResult.setText(strNumbers);

                cursor.close();
                sqlDB.close();
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View UpdateView = (View)View.inflate(MainActivity.this, R.layout.dlg_update, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("그룹 정보 변경");
                dlg.setView(UpdateView);

                final EditText edtUpName = UpdateView.findViewById(R.id.edtUpName);
                final EditText edtUpNumber = UpdateView.findViewById(R.id.edtUpNumber);

                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String number = edtUpNumber.getText().toString().trim();
                            String name = edtUpName.getText().toString().trim();

                            if (!number.isEmpty() && !name.isEmpty()) {
                                String sql = "UPDATE groupTBL SET gNumber = " + number + " WHERE gName = '" + name + "'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "수정되었습니다.", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            } else {
                                Toast.makeText(getApplicationContext(), "이름과 인원을 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "수정 실패", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View DeleteView = (View)View.inflate(MainActivity.this, R.layout.dlg_delete, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dlg.setTitle("그룹 정보 삭제");
                dlg.setView(DeleteView);

                final EditText edtDeName = DeleteView.findViewById(R.id.edtDeName);

                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edtDeName.getText().toString().trim();

                            if (!name.isEmpty()) {
                                String sql = "DELETE FROM groupTBL WHERE gName = '"+name+"'";
                                sqlDB.execSQL(sql);
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                                btnSelect.callOnClick();
                            } else {
                                Toast.makeText(getApplicationContext(), "이름을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

    }
}

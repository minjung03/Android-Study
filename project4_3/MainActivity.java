package com.cookandroid.project4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtAnimal;
    CheckBox chkAgree;
    RadioGroup rdoGruop;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOk;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2102 김민정");

        txtAnimal = (TextView) findViewById(R.id.txtAnimal);
        chkAgree = (CheckBox) findViewById(R.id.chkAgree);
        rdoGruop = (RadioGroup) findViewById(R.id.rdoGroup);
        rdoDog = (RadioButton) findViewById(R.id.rdoDog);
        rdoCat = (RadioButton) findViewById(R.id.rdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.rdoRabbit);
        btnOk = (Button) findViewById(R.id.btnOK);
        imgPet = (ImageView) findViewById(R.id.imgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkAgree.isChecked() == true) {  //버튼을 체크 했어?

                    txtAnimal.setVisibility(View.VISIBLE); //체크 했으면 보이게
                    rdoGruop.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {

                    txtAnimal.setVisibility(View.INVISIBLE);  //체크 안했으면 안보이게
                    rdoGruop.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdoGruop.getCheckedRadioButtonId()) {
                    case R.id.rdoDog:
                        imgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rdoCat:
                        imgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(), "먼저 동물을 선택해 주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

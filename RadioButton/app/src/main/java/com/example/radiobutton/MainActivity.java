package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton com, chao, pho;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        com = (RadioButton) findViewById(R.id.com);
        chao = (RadioButton) findViewById(R.id.chao);
        pho = (RadioButton) findViewById(R.id.pho);
        button=(Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(com.isChecked()){
                    Toast.makeText(MainActivity.this, "Cơm", Toast.LENGTH_SHORT).show();
                } else if (chao.isChecked()) {
                    Toast.makeText(MainActivity.this, "Cháo", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Phở",Toast.LENGTH_SHORT).show();
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //checkedID trả về id của radioButton
                if(checkedId==R.id.chao){
                    Toast.makeText(MainActivity.this, "Cháo", Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.com){
                    Toast.makeText(MainActivity.this, "Cơm", Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.pho){
                    Toast.makeText(MainActivity.this, "Phở", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}



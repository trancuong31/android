package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox com,pho,chao;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        anhXa();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thucan="bạn đã chọn: ";
                if(com.isChecked()){
                    thucan+="Cơm ";
                }
                if(pho.isChecked()){
                    thucan+="Phở ";
                }
                if(chao.isChecked()){
                    thucan+="Cháo";
                }
                Toast.makeText(MainActivity.this, thucan, Toast.LENGTH_SHORT).show();
            }

        });
        com.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Bạn đã click vào Cơm", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Bạn đã Unclick vào Cơm", Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
    public void anhXa(){
        com=(CheckBox) findViewById(R.id.com);
        pho=(CheckBox) findViewById(R.id.pho);
        chao=(CheckBox) findViewById(R.id.chao);
        button=(Button) findViewById(R.id.button);
    }
}
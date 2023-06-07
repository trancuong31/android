package com.example.cuocduatopcasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar1,seekBar2,seekBar3;
    CheckBox checkBox1,checkBox2,checkBox3;
    ImageButton run;
    TextView diem;
    int tong=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        anhXa();
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        diem.setText(tong+"");
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox2.setChecked(false);
                    checkBox1.setChecked(false);
                }
            }
        });
        CountDownTimer countDownTimer =new CountDownTimer(6000,300) {
            @Override

            public void onTick(long millisUntilFinished) {
                int number=20   ;
                Random random=new Random();
                //random từ 0 đến 20 cho 3 biến one, two, three
                int one=random.nextInt(number);
                int two=random.nextInt(number);
                int three=random.nextInt(number);
                //kiểm tra xem win
                
                if(seekBar1.getProgress()>=seekBar1.getMax()){

                    Toast.makeText(MainActivity.this, "Three win", Toast.LENGTH_SHORT).show();
                    run.setVisibility(View.VISIBLE);

                    if(checkBox1.isChecked()){
                        tong+=10;
                    }
                    else{
                        tong-=10;
                    }
                    diem.setText(tong+"");
                    enable();
                    this.cancel();
                }
                if(seekBar2.getProgress()>=seekBar2.getMax()){
                    Toast.makeText(MainActivity.this, "Two win", Toast.LENGTH_SHORT).show();
                    run.setVisibility(View.VISIBLE);

                    if(checkBox2.isChecked()){
                        tong+=10;
                    }
                    else{
                        tong-=10;
                    }
                    diem.setText(tong+"");
                    enable();
                    this.cancel();
                }
                if(seekBar3.getProgress()>=seekBar3.getMax()){
                    Toast.makeText(MainActivity.this, "One win", Toast.LENGTH_SHORT).show();
                    run.setVisibility(View.VISIBLE);

                    if(checkBox3.isChecked()){
                        tong+=10;
                    }
                    else{
                        tong-=10;
                    }
                    diem.setText(tong+"");
                    enable();
                    this.cancel();

                }
                
                seekBar1.setProgress(seekBar1.getProgress()+one);
                seekBar2.setProgress(seekBar2.getProgress()+two);
                seekBar3.setProgress(seekBar3.getProgress()+three);

            }

            @Override
            public void onFinish() {

            }
        };
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()||checkBox2.isChecked()||checkBox3.isChecked()){
                    run.setVisibility(View.INVISIBLE);
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);
                    if(tong<=80) {
                        Toast.makeText(MainActivity.this, "Bạn sắp hết tiền oy, không nên chơi nữa", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        countDownTimer.start();
                        disenable();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Vui lòng chọn con vật trước khí Click", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void anhXa(){
        seekBar1=(SeekBar) findViewById(R.id.seekBar1);
        seekBar2=(SeekBar) findViewById(R.id.seekBar2);
        seekBar3=(SeekBar) findViewById(R.id.seekBar3);
        checkBox1=(CheckBox) findViewById(R.id.checkbox1);
        checkBox2=(CheckBox) findViewById(R.id.checkbox2);
        checkBox3=(CheckBox) findViewById(R.id.checkbox3);
        run=(ImageButton) findViewById(R.id.run);
        diem=(TextView) findViewById(R.id.diem);
    }
    public void enable(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }
    public void disenable(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
}
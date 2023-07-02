package com.example.intentbaitap;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
     public static ArrayList<String> arrayList;
    ImageView imggoc,imgnhan;
    String tenhinhgoc;
    TextView D;
    SharedPreferences sharedPreferences;
    int diem=100;
    void luudiem(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("diem",diem);
        editor.commit();
    }
    final private ActivityResultLauncher<Intent> activityResultLauncher= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode()==RESULT_OK){
                Intent intent=result.getData();
                String tenhinh=intent.getStringExtra("dulieu");
                int idhinhnhan=getResources().getIdentifier(tenhinh,"drawable",getPackageName());
                imgnhan.setImageResource(idhinhnhan);

                if(tenhinh.equals(tenhinhgoc)){
                    Toast.makeText(MainActivity.this,"Chính xác",Toast.LENGTH_SHORT).show();

                    diem+=10;
                    luudiem();
                    new CountDownTimer(2000, 500) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            Collections.shuffle(arrayList);
                            tenhinhgoc=arrayList.get(5);
                            int idhinh=getResources().getIdentifier(arrayList.get(5),"drawable",getPackageName());
                            imggoc.setImageResource(idhinh);
                        }
                    }.start();
                }
                else {
                    Toast.makeText(MainActivity.this, "Sai", Toast.LENGTH_SHORT).show();
                    diem-=10;
                    luudiem();
                }
            }
            if(result.getResultCode()==RESULT_CANCELED){
                Toast.makeText(MainActivity.this, "bạn chưa chọn ảnh", Toast.LENGTH_SHORT).show();
                diem-=10;
                luudiem();
            }
            D.setText(diem+"");
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imggoc=findViewById(R.id.imageView);
        imgnhan=findViewById(R.id.imageView2);
        D=findViewById(R.id.diem);
        String[]mangten=getResources().getStringArray(R.array.listname);
        arrayList=new ArrayList<>(Arrays.asList(mangten));
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        D.setText(sharedPreferences.getInt("diem",100)+"");
        Collections.shuffle(arrayList);
        tenhinhgoc=arrayList.get(5);
        int idhinh=getResources().getIdentifier(arrayList.get(5),"drawable",getPackageName());
        imggoc.setImageResource(idhinh);

        imgnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ImageActivity.class);
                activityResultLauncher.launch(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reload,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.reload){
            Collections.shuffle(arrayList);
            tenhinhgoc=arrayList.get(5);
            int idhinh=getResources().getIdentifier(arrayList.get(5),"drawable",getPackageName());
            imggoc.setImageResource(idhinh);
        }
        return super.onOptionsItemSelected(item);
    }
}
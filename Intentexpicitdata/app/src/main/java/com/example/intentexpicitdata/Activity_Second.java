package com.example.intentexpicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_Second extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.textView);
        Intent intent=getIntent();
        hocsinh hs= (hocsinh) intent.getSerializableExtra("dulieu");
//        textView.setText(intent.getStringArrayExtra("dulieu")[1].toString());
//        textView.setText(hs.getName()+" ở "+hs.getDiaChi());
        Bundle bundle=intent.getBundleExtra("all");
        String chuoi=bundle.getString("chuoi");
        int so= bundle.getInt("so");
        int[]a= bundle.getIntArray("mang");
        hocsinh aa= (hocsinh) bundle.getSerializable("doituong");
        textView.setText(chuoi+" "+so+" "+a[2]+" "+aa.getName().toString()+"");
    }
}
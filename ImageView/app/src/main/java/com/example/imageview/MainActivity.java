package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RelativeLayout relativeLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        relativeLayout=(RelativeLayout) findViewById(R.id.relativeLayout);
        imageView= (ImageView) findViewById(R.id.img);
        imageView.setImageResource(R.drawable.sontung1);
        relativeLayout.setBackgroundResource(R.drawable.sontung);
    }
}
package com.example.hinhnenrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    List<Integer> backgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=(LinearLayout) findViewById(R.id.linearLayout);
        backgroup=new ArrayList<>();
        Random random=new Random();
        backgroup.add(R.drawable.songoku);
        backgroup.add(R.drawable.sontung);
        backgroup.add(R.drawable.sontung1);
        backgroup.add(R.drawable.sontung2);

        int rs=random.nextInt(backgroup.size());

        linearLayout.setBackgroundResource(backgroup.get(rs));
    }
}
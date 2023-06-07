package com.example.gridviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private hinhanhadapter adapter;
    private List<hinhAnh> hinhAnhList;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView) findViewById(R.id.gridView);
        hinhAnhList=new ArrayList<>();
        hinhAnhList.add(new hinhAnh(R.drawable.amee,"Ảnh 1"));
        hinhAnhList.add(new hinhAnh(R.drawable.iu,"Ảnh 2"));
        hinhAnhList.add(new hinhAnh(R.drawable.jack,"Ảnh 3"));
        hinhAnhList.add(new hinhAnh(R.drawable.sontung,"Ảnh 4"));
        hinhAnhList.add(new hinhAnh(R.drawable.sontung1,"Ảnh 5"));
        hinhAnhList.add(new hinhAnh(R.drawable.sontung2,"Ảnh 6"));
        hinhAnhList.add(new hinhAnh(R.drawable.sontung3,"Ảnh 7"));
        hinhAnhList.add(new hinhAnh(R.drawable.mytam,"Ảnh 8"));
        adapter=new hinhanhadapter(MainActivity.this,R.layout.donghinhanh,hinhAnhList);
        gridView.setAdapter(adapter);
    }
}
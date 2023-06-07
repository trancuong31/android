package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
GridView gridView;
String[] table= {"A","B","C","D","E","F","G","H","J","K","L","M","N"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=(GridView) findViewById(R.id.gridview);
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,table);
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn đã click vào "+table[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
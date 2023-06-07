package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText text;
    int i=-1;
    Button delete,insert,update;
    List<String> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText) findViewById(R.id.text);
        listView=(ListView) findViewById(R.id.list);
        delete=(Button) findViewById(R.id.xoa);
        insert=(Button) findViewById(R.id.them);
        update=(Button) findViewById(R.id.capnhat);
        list.add("Môn A");
        list.add("Môn B");
        list.add("Môn C");
        list.add("Môn D");
        list.add("Môn E");
        list.add("Môn F");
        list.add("Môn G");
        list.add("Môn H");
        list.add("Môn J");
        list.add("Môn K");
        list.add("Môn L");
        list.add("Môn M");
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                text.setText(list.get(position));
                Toast.makeText(MainActivity.this, "Bạn đã click vào "+list.get(position), Toast.LENGTH_SHORT).show();
                i=position;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn đã xóa "+list.get(position), Toast.LENGTH_SHORT).show();
                list.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=text.getText().toString();
                list.add(input);
                arrayAdapter.notifyDataSetChanged();
                if(input!= null){
                    text.setText("");
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in=text.getText().toString();
                 list.set(i,in);
                Toast.makeText(MainActivity.this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                    arrayAdapter.notifyDataSetChanged();
                if(in!= null){
                    text.setText("");
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in=text.getText().toString();
                list.remove(in);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
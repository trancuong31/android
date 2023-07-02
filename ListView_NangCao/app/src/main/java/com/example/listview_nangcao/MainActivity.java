package com.example.listview_nangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<CaSi> caSiList;
    CaSiAdapter traiCayadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        traiCayadapter=new CaSiAdapter(caSiList,this,R.layout.dong_casi);
        listView.setAdapter(traiCayadapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Bạn đã xóa "+ caSiList.get(position).getTen(), Toast.LENGTH_SHORT).show();
                caSiList.remove(position);
                traiCayadapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    public void anhXa(){
        listView=(ListView) findViewById(R.id.listView);
        caSiList=new ArrayList<>();
        caSiList.add(new CaSi("Sơn Tùng","Đẹp trai,tài giỏi",R.drawable.sontung));
        caSiList.add(new CaSi("Jack","Đẹp trai, giỏi",R.drawable.jack));
        caSiList.add(new CaSi("Mỹ Tâm","tài giỏi",R.drawable.mytam));
        caSiList.add(new CaSi("IU","Xinh,tài giỏi",R.drawable.iu));
        caSiList.add(new CaSi("AMee","Xinh,tài giỏi",R.drawable.amee));
        caSiList.add(new CaSi("Sơn Tùng","Đẹp trai,tài giỏi",R.drawable.sontung));
        caSiList.add(new CaSi("Jack","Đẹp trai, giỏi",R.drawable.jack));
        caSiList.add(new CaSi("Mỹ Tâm","tài giỏi",R.drawable.mytam));
        caSiList.add(new CaSi("IU","Xinh,tài giỏi",R.drawable.iu));
        caSiList.add(new CaSi("AMee","Xinh,tài giỏi",R.drawable.amee));
        caSiList.add(new CaSi("Sơn Tùng","Đẹp trai,tài giỏi",R.drawable.sontung));
        caSiList.add(new CaSi("Jack","Đẹp trai, giỏi",R.drawable.jack));
        caSiList.add(new CaSi("Mỹ Tâm","tài giỏi",R.drawable.mytam));
        caSiList.add(new CaSi("IU","Xinh,tài giỏi",R.drawable.iu));
        caSiList.add(new CaSi("AMee","Xinh,tài giỏi",R.drawable.amee));
        caSiList.add(new CaSi("Sơn Tùng","Đẹp trai,tài giỏi",R.drawable.sontung));
        caSiList.add(new CaSi("Jack","Đẹp trai, giỏi",R.drawable.jack));
        caSiList.add(new CaSi("Mỹ Tâm","tài giỏi",R.drawable.mytam));
        caSiList.add(new CaSi("IU","Xinh,tài giỏi",R.drawable.iu));
        caSiList.add(new CaSi("AMee","Xinh,tài giỏi",R.drawable.amee));
    }
}
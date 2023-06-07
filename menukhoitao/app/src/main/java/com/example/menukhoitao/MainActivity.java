package com.example.menukhoitao;

import static com.example.menukhoitao.R.id.button2;
import static com.example.menukhoitao.R.id.item1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button,button2;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        constraintLayout=(ConstraintLayout) findViewById(R.id.layout) ;
        //đăng kí view cho context menu
        registerForContextMenu(button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
      }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context,menu);
        menu.setHeaderIcon(R.drawable.icon2);

        menu.setHeaderTitle("Thông báo");



        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.maudo){
            constraintLayout.setBackgroundColor(Color.RED);
        } else if (item.getItemId()==R.id.mauhong) {
            constraintLayout.setBackgroundColor(Color.rgb(255, 192, 203));
        }
        else {
            constraintLayout.setBackgroundColor(Color.GREEN);
        }
        return super.onContextItemSelected(item);
    }

    private void showMenu(){
        PopupMenu popupMenu= new PopupMenu(this,button);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.them){
                    Toast.makeText(MainActivity.this, "Bạn đã click vào Thêm", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.sua) {
                    Toast.makeText(MainActivity.this, "Bạn đã click vào Sửa", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Bạn đã click vào Xóa", Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.item1){
            Toast.makeText(this, "Bạn đã click vào item1", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item2){
            Toast.makeText(this, "Bạn đã click vào item2", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item3){
            Toast.makeText(this, "Bạn đã click vào item3", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item5){
            Toast.makeText(this, "Bạn đã click vào item5", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item6){
            Toast.makeText(this, "Bạn đã click vào item6", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.item7){
            Toast.makeText(this, "Bạn đã click vào item7", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
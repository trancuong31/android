package com.example.intentexpicitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Activity_Second.class);
                //truyền dư liệu mảng
//                String[]a={"Cường","Hùng","Lan Anh"};
//                intent.putExtra("dulieu",a );
                //truyền dữ liệu đối tượng
//                hocsinh hs= new hocsinh("Cường","Vĩnh phúc");
//                intent.putExtra("dulieu",hs);
                //truyền dữ liệu bundle
                int[]a ={4,6,8,5,3};
                hocsinh hs= new hocsinh("Cường","Vĩnh phúc");
                Bundle bundle=new Bundle();
                bundle.putString("chuoi","Anh yêu em");
                bundle.putInt("so",5);
                bundle.putIntArray("mang",a);
                bundle.putSerializable("doituong",hs);
                intent.putExtra("all",bundle);
                startActivity(intent);
            }
        });
    }
}
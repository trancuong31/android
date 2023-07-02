package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,password;
    Button login;
    CheckBox cb;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sharedPreferences= getSharedPreferences("data",MODE_PRIVATE);
        user.setText(sharedPreferences.getString("taikhoan",""));
        password.setText(sharedPreferences.getString("matkhau",""));
        cb.setChecked(sharedPreferences.getBoolean("check",false));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u=user.getText().toString().trim();
                String p=password.getText().toString().trim();

                if(u.equals("admin")&&p.equals("a")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    if(cb.isChecked()){
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("taikhoan",u);
                        editor.putString("matkhau",p);
                        editor.putBoolean("check",true);
                        editor.commit();
                    }
                    else {
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("taikhoan","");
                        editor.putString("matkhau","");
                        editor.putBoolean("check",false);
                        editor.commit();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "thất bại", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
    void anhxa(){
        user=findViewById(R.id.user);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        cb=findViewById(R.id.checkBox);
    }
}
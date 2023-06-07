package com.example.applanguege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Name,Email,Phonenumber;
    TextView In;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.name);
        Email= (EditText) findViewById(R.id.email);
        Phonenumber= (EditText) findViewById(R.id.phonenumber);
        In= (TextView) findViewById(R.id.in);
        button=(Button) findViewById(R.id.button);
        String name= getResources().getString(R.string.hint_ten);
        String email= getResources().getString(R.string.hint_email);
        String phone= getResources().getString(R.string.hint_sdt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten=Name.getText().toString();
                String emai=Email.getText().toString();
                String number=Phonenumber.getText().toString();
                In.setText(name+": "+ten+"\n "+emai+": "+emai+"\n"+phone+": "+number );
            }
        });
    }
}
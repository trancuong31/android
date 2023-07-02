package com.example.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editActivity extends AppCompatActivity {
    EditText editText;
    Button confirm;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editText=findViewById(R.id.editText);
        confirm=findViewById(R.id.button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=editText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("dulieu",content);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_1 extends AppCompatActivity {
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_1.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.d("B","on Create");
    }

    public Activity_1() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("B","on Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("B","on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("B","on Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("B","on Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("B","on Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("B","on Restart");
    }
}
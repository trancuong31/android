package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                Intent intent= new Intent (MainActivity.this,Activity_1.class);
                startActivity(intent);
            }
        });
        Log.d("A","on Create");

    }

    public MainActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("A","on Start");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("A","on Stop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("A","on Destroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("A","on Pause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("A","on Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("A","on Restart");
    }
}
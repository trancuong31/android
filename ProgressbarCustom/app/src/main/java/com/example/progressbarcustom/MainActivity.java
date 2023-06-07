package com.example.progressbarcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler= progressBar.getHandler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(progressBar.getProgress()>=progressBar.getMax()){
                            progressBar.setProgress(0);
                            progressBar.setSecondaryProgress(10);
                        }
                        else{
                            progressBar.setProgress(progressBar.getProgress()+1);
                            progressBar.setSecondaryProgress(progressBar.getSecondaryProgress()+1);
                        }
                        handler.postDelayed(this,100);
                    }
                },100);

            }
        });
    }
}
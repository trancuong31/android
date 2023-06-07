package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ProgressBar load;
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load=(ProgressBar) findViewById(R.id.load);
        bt=(Button) findViewById(R.id.button1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int a = load.getProgress();
                        if (a >= load.getMax()) {
                            a = 0;
                        }
                        load.setProgress(a + 20);
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        Toast.makeText(MainActivity.this, "hết 1 vòng", Toast.LENGTH_SHORT).show();
                    }
                };
                    countDownTimer.start();
            }
        });

    }
}
package com.example.drawableclip;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img= (ImageView) findViewById(R.id.imageView);
        button=(Button) findViewById(R.id.button);

        ClipDrawable clipDrawable = (ClipDrawable) img.getDrawable();
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Handler handler=new Handler();
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         img.setImageLevel(clipDrawable.getLevel()+1000);
                         if(clipDrawable.getLevel()>10000){
                             img.setImageLevel(0);
                         }
                         handler.postDelayed(this,500);
                     }
                 },500);

             }
         });
    }
}
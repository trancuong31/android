package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView sontung,bell,run,sontung2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sontung=findViewById(R.id.sontung);
        bell=findViewById(R.id.sontung1);
        run=findViewById(R.id.run);
        sontung2=findViewById(R.id.sontung2);
        Animation animationScale=AnimationUtils.loadAnimation(this,R.anim.scale);
        Animation animationAlpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation anmationRotate=AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation animationTranslate=AnimationUtils.loadAnimation(this,R.anim.translate);
        sontung2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationScale);
            }
        });
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationTranslate);
            }
        });
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anmationRotate);
            }
        });
        sontung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationAlpha);
            }
        });
    }
}
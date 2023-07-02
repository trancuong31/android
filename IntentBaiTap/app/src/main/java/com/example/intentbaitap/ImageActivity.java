package com.example.intentbaitap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Collections;

public class ImageActivity extends AppCompatActivity {
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        tableLayout=findViewById(R.id.tab);

        int sodong=4;
        int socot=2;
        Collections.shuffle(MainActivity.arrayList);
        for(int i=0;i<sodong;i++){
            TableRow tableRow=new TableRow(this);
            for (int j=0;j<socot;j++){
                ImageView imageView=new ImageView(this);
                // Converts 150 dip into its equivalent px

                Resources r = getResources();
                int px = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        150,
                        r.getDisplayMetrics()
                );

                TableRow.LayoutParams layoutParams=new TableRow.LayoutParams(px,px);
                imageView.setLayoutParams(layoutParams);
                int vitri=socot*(i)+j;
                int idHinh=getResources().getIdentifier(MainActivity.arrayList.get(vitri),"drawable",getPackageName());
                imageView.setImageResource(idHinh);
                tableRow.addView(imageView);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent();
                        intent.putExtra("dulieu",MainActivity.arrayList.get(vitri));
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                });

            }
            tableLayout.addView(tableRow);
        }

    }



}
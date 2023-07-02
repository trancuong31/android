package com.example.readcontentinterner_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                //doInBackground
                ExecutorService executorService= Executors.newSingleThreadExecutor();
                Handler handler=new Handler();
                executorService.execute(new Runnable() {

                    @Override
                    public void run() {
                        StringBuilder stringBuilder= new StringBuilder();
                        try {
                            URL url=new URL("https://docbao.vn/");
                            URLConnection urlConnection=url.openConnection();
                            InputStream inputStream=urlConnection.getInputStream();
                            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                            String line="";
                            while ((line=bufferedReader.readLine())!=null){
                                stringBuilder.append(line+"");
                            }
                            bufferedReader.close();
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();

                            }
                        });
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
                    }
                });
            }
        });
    }
}
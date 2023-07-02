package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    Button button;
    Bitmap image=null;
    ImageView imageView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //doInpreExcute
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                //new congviec().execute();
                 ExecutorService executorService= Executors.newSingleThreadExecutor();
                 Handler handler=new Handler(Looper.getMainLooper());
                 executorService.execute(new Runnable() {
                     @Override
                     public void run() {
                        //doInBackground
                         try {
                             URL url=new URL("https://upload.wikimedia.org/wikipedia/vi/9/93/S%C6%A1n_T%C3%B9ng_M-TP_-_Mu%E1%BB%99n_r%E1%BB%93i_m%C3%A0_sao_c%C3%B2n.png");
                             HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                             httpURLConnection.connect();
                             image= BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                         } catch (MalformedURLException e) {
                             throw new RuntimeException(e);
                         } catch (IOException e) {
                             throw new RuntimeException(e);
                         }
                        //doInPostBackground
                         runOnUiThread(new Runnable() {
                             @Override
                             public void run() {
                                 imageView.setImageBitmap(image);
                             }
                         });

                     }
                 });

            }
        });
    }

//    private class congviec extends AsyncTask<Void,String,String>{
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            textView.setText("Bắt đầu"+"\n");
//        }
//
//        @Override
//        protected String doInBackground(Void... voids) {
//
//            return "Cường";
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            textView.append("Xong");
//        }
//    }
}
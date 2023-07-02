package com.example.docbaorss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayList<String> arrayListLink;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        arrayList=new ArrayList<>();
        arrayListLink=new ArrayList<>();
        adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this, NewActivity.class );
                intent.putExtra("link",arrayListLink.get(position));
               startActivity(intent);
            }
        });
        executorService.execute(new Runnable() {
            StringBuilder content=new StringBuilder();
            @Override
            public void run() {
                URL url= null;
                try {
                    url = new URL("https://vnexpress.net/rss/phap-luat.rss");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                URLConnection urlConnection= null;
                try {
                    urlConnection = url.openConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                InputStream inputStream= null;
                try {
                    inputStream = urlConnection.getInputStream();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line="";
                while (true){
                    try {
                        if (!((line=bufferedReader.readLine())!=null)) break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    content.append(line+"");
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        XMLDOMParser parser= new XMLDOMParser();
                        Document document=parser.getDocument(content.toString());
                        NodeList nodeList=document.getElementsByTagName("item");
                        String tieude="";
                        for(int i=0;i<nodeList.getLength();i++){
                            Element element= (Element) nodeList.item(i);
                            tieude=parser.getValue(element,"title");
                            arrayListLink.add(parser.getValue(element,"link"));
                            arrayList.add(tieude);

                        }
                        adapter.notifyDataSetChanged();

                    }
                });
            }
        });
    }
}
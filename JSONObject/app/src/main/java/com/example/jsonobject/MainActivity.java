package com.example.jsonobject;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String json=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        Gson gson=new Gson();
        salary salary=new salary(23435000,12);
        employees employee=new employees("Trần","Cường",salary);
        //Serialization
       // String json=gson.toJson(employee);
       //Log.d("Tag",json);

        //Toast.makeText(this, json, Toast.LENGTH_SHORT).show();
        //Deserialization
//        String data="{\n" +
//                "  \"employees\":[\n" +
//                "    {\"firstName\":\"Hưng\", \"lastName\":\"Nguyễn\"},\n" +
//                "    {\"firstName\":\"Trường\", \"lastName\":\"Nguyễn\"},\n" +
//                "  ]\n" +
//                "}";
//        employees employee1=gson.fromJson(data, employees.class);
//        Toast.makeText(this, employee1.getFirtName().toString(), Toast.LENGTH_LONG).show();
        String json="{\"firtName\":\"Trần\",\"lastName\":\"Cường\",\"salary\":{\"basicSalary\":2.3435E7,\"coefficientsSalary\":12}}";
        employees employees1=gson.fromJson(json,employees.class);
        Log.d("TAg",employees1.toString());
    }
}
package com.example.json_arrayinobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        List<Course> courseList=new ArrayList<>();
//        courseList.add(new Course("Java",299));
//        courseList.add(new Course("Kotlin",123));
//        courseList.add(new Course("C#",228));
//
//        Student student=new Student("Cường",21,courseList);
       Gson gson=new Gson();
//        String json=gson.toJson(student);
//        Log.d("A",student.toString());
        String json_data="{\"age\":21,\"courseList\":[{\"course_name\":\"Java\",\"fees\":299.0},{\"course_name\":\"Kotlin\",\"fees\":123.0},{\"course_name\":\"C#\",\"fees\":228.0}],\"name\":\"Cường\"}";
        Student student=gson.fromJson(json_data,Student.class);
        Log.d("A",student.toString());
    }
}
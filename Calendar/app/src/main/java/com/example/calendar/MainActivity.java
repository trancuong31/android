package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText ngaydau,ngaycuoi;
    Button button;
    TextView textView;
    Calendar calendar,calendar1,calendar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                // Lấy thời gian hiện tại
                long currentTime = System.currentTimeMillis();

                // Chuyển đổi thời gian thành chuỗi để hiển thị
                String timeString = DateFormat.getTimeInstance().format(new Date(currentTime));

                // Cập nhật giá trị của TextView
                textView.setText(timeString);

                // Lặp lại việc cập nhật giá trị sau 1 giây
                handler.postDelayed(this, 1000);


            }
        };
        handler.postDelayed(runnable,0);
        ngaydau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgayDau();
            }
        });
        ngaycuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonNgayCuoi();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((calendar1.getTimeInMillis()-calendar.getTimeInMillis())<0){
                    Toast.makeText(MainActivity.this, "nhập lại ngày cuối lớn hơn ngày đầu", Toast.LENGTH_LONG).show();
                }
                else {
                    int ngay= (int) (calendar1.getTimeInMillis()-calendar.getTimeInMillis())/ (1000*60*60*24);
                    textView.setText("Tổng ngày là: "+ ngay);
                }

            }
        });
    }
    private void anhxa(){
        ngaydau= (EditText) findViewById(R.id.date);
        ngaycuoi= (EditText) findViewById(R.id.date2);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
    }
    private void chonNgayDau(){
         calendar=Calendar.getInstance();
        int day=calendar.get(Calendar.DATE);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        DatePickerDialog datePicker=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                ngaydau.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },year,month,day);
        datePicker.show();
    }
    private void chonNgayCuoi(){
         calendar1=Calendar.getInstance();
        int day=calendar1.get(Calendar.DATE);
        int month=calendar1.get(Calendar.MONTH);
        int year=calendar1.get(Calendar.YEAR);
        DatePickerDialog datePicker=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar1.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                ngaycuoi.setText(simpleDateFormat.format(calendar1.getTime()));
            }
        },year,month,day);
        datePicker.show();
    }
}
package com.example.random;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText numberFirt;
    EditText numberLast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        anhXa();

        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String rong="";
                String soDau=numberFirt.getText().toString().trim();
                String soCuoi=numberLast.getText().toString().trim();
                if(soDau.equals(rong)||soCuoi.equals(rong)){
                    Toast.makeText(MainActivity.this, "Vui lòng không để rỗng", Toast.LENGTH_SHORT).show();
                }
                else {
                    int dau=Integer.parseInt(soDau);
                    int cuoi=Integer.parseInt(soCuoi);

                    if(dau>cuoi){
                        Toast.makeText(MainActivity.this, "Vui lòng nhập số đầu < số cuói", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Random random=new Random();
                        int number=random.nextInt(cuoi-dau+1)+dau;
                        textView.setText(number+"");
                    }

                }


            }
        });
    }

        public void anhXa(){
            textView=(TextView) findViewById(R.id.textview);
            button=(Button) findViewById(R.id.button);
            numberFirt=(EditText) findViewById(R.id.numberFirt);
            numberLast=(EditText) findViewById(R.id.numberLast);
        }

}
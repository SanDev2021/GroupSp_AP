package com.example.projectandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_info);
TextView tvInfo=findViewById(R.id.tvInfo);
String info=getIntent().getStringExtra("INFO");
tvInfo.setText(info);

    }

}

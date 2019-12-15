package com.example.projectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectandroid.adapter.EmployeeListAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EmployeeListAdapter adapter = new EmployeeListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);


        ListView lvEmployeeList = findViewById(R.id.lvEmployeeList);
        lvEmployeeList.setAdapter(adapter);
        lvEmployeeList.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, AppData.employees.get(position).toDisplay(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, EmployeeInfoActivity.class);
        intent.putExtra("INFO", AppData.employees.get(position).toDisplay());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}

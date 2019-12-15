package com.example.projectandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projectandroid.AppData;
import com.example.projectandroid.R;
import com.example.projectandroid.employee.Employee;

public class EmployeeListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return AppData.employees.size();
    }

    @Override
    public Employee getItem(int position) {
        return AppData.employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvId = convertView.findViewById(R.id.tvId);

        tvName.setText(AppData.employees.get(position).getFirstName());
        tvId.setText(AppData.employees.get(position).getId().toString());
        return convertView;
    }
}

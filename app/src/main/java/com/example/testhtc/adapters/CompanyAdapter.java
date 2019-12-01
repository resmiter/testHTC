package com.example.testhtc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testhtc.R;
import com.example.testhtc.struct.Employee;

import java.util.List;

public class CompanyAdapter extends BaseAdapter {

    private List<Employee> employeeList;
    private LayoutInflater layoutInflater;

    public CompanyAdapter(Context context, List<Employee> list) {
        this.employeeList = list;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int i) {
        return employeeList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_employee, viewGroup, false);
        }

        Employee employee = getEmployee(i);
        TextView itemName = view.findViewById(R.id.itemName);
        itemName.setText(employee.toString());
        return view;
    }

    private Employee getEmployee(int i) {
        return (Employee) getItem(i);
    }
}

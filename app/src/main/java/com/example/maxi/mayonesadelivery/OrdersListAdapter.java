package com.example.maxi.mayonesadelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OrdersListAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> list;
    TextView tvValue;
    public OrdersListAdapter(Context context, List<String> list) {
        super(context, R.layout.order_list_adapter_row, android.R.id.text1, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.order_list_adapter_row, parent, false);

        tvValue = (TextView)row.findViewById(R.id.tvValue);
        tvValue.setText(list.get(position));
        return row;
    }
}

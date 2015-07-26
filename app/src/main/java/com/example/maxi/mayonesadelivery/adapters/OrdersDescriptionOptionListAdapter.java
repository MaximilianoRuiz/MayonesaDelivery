package com.example.maxi.mayonesadelivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.maxi.mayonesadelivery.R;

import java.util.List;

public class OrdersDescriptionOptionListAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> options, values;
    TextView tvValue, tvOption;
    public OrdersDescriptionOptionListAdapter(Context context, List<String> options,  List<String> values) {
        super(context, R.layout.order_description_option_list_adapter_row, android.R.id.text1, options);
        this.context = context;
        this.options = options;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.order_description_option_list_adapter_row, parent, false);

        tvValue = (TextView)row.findViewById(R.id.tvValue);
        tvValue.setText(values.get(position));

        tvOption = (TextView)row.findViewById(R.id.tvOption);
        tvOption.setText(options.get(position));
        return row;
    }
}

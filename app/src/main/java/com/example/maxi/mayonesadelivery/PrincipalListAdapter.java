package com.example.maxi.mayonesadelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PrincipalListAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> list;
    public PrincipalListAdapter(Context context, List<String> list) {
        super(context, R.layout.principal_list_adapter_row, android.R.id.text1, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.principal_list_adapter_row, parent, false);

        TextView t = (TextView) row.findViewById(R.id.tvPayValue);
        t.setText(list.get(position));
        return row;
    }
}

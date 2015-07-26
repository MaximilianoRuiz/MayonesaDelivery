package com.example.maxi.mayonesadelivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maxi.mayonesadelivery.R;

import java.util.List;

public class MenuListAdapter extends ArrayAdapter<String> {
    Context context;
    List<String> list;
    List<Integer> iconList;
    public MenuListAdapter(Context context, List<String> list, List<Integer> iconList) {
        super(context, R.layout.principal_list_adapter_row, android.R.id.text1, list);
        this.context = context;
        this.list = list;
        this.iconList = iconList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.menu_list_adapter_row, parent, false);

        TextView t = (TextView) row.findViewById(R.id.tvMenu);
        t.setText(list.get(position));

        ImageView imageView = (ImageView) row.findViewById(R.id.ivIconMenu);
        imageView.setBackgroundResource(iconList.get(position));

        return row;
    }
}

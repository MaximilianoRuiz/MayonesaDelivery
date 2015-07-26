package com.example.maxi.mayonesadelivery;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.maxi.mayonesadelivery.adapters.OrdersListAdapter;
import com.example.maxi.mayonesadelivery.dialogs.MyOrderListItemDialog;

import java.util.ArrayList;
import java.util.List;


public class MyOrders extends ActionBarActivity {

    ActionBar actionBar;
    ListView lvOrderList;
    List<String> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ef0006")));

        lvOrderList = (ListView) findViewById(R.id.lvOrdersList);

        orders = new ArrayList<>();
        orders.add("$100");
        orders.add("$300");
        orders.add("$170");

        lvOrderList.setAdapter(new OrdersListAdapter(getBaseContext(), orders));

        lvOrderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemDialog(view, orders.get(position));
            }
        });
    }

    private void itemDialog(View v, String value){
        MyOrderListItemDialog myDialog = new MyOrderListItemDialog(value);
        myDialog.show(this.getFragmentManager(), "Dialog");
    }
}

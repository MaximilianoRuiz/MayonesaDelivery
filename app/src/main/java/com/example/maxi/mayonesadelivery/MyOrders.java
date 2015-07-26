package com.example.maxi.mayonesadelivery;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MyOrders extends ActionBarActivity {

    ListView lvOrderList;
    List<String> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

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
        OrderListItemDialog myDialog = new OrderListItemDialog(value);
        myDialog.show(this.getFragmentManager(), "Dialog");
    }
}

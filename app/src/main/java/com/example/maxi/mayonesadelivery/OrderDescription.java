package com.example.maxi.mayonesadelivery;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.maxi.mayonesadelivery.adapters.OrdersDescriptionOptionListAdapter;

import java.util.ArrayList;
import java.util.List;


public class OrderDescription extends ActionBarActivity {

    ActionBar actionBar;
    ListView lvOrderDescriptionList, lvOrderOption;
    List<String> orderDescriptionList, orderDescriptionOptionList, orderDescriptionValuesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_description);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ef0006")));

        orderDescriptionList = new ArrayList<>();
        orderDescriptionList.add("1 - Lomito Completo - $50");
        orderDescriptionList.add("3 - Lomito Simple - $130");
        orderDescriptionList.add("1 - Pizza Especial - $100");

        orderDescriptionOptionList = new ArrayList<>();
        orderDescriptionOptionList.add("Efectivo/Tarjeta");
        orderDescriptionOptionList.add("A pagar");
        orderDescriptionOptionList.add("Nota");

        orderDescriptionValuesList = new ArrayList<>();
        orderDescriptionValuesList.add("Efectivo");
        orderDescriptionValuesList.add("$200");
        orderDescriptionValuesList.add("Sin mayonesa");

        lvOrderDescriptionList = (ListView) findViewById(R.id.lvOrderDescriptionList);
        lvOrderOption = (ListView) findViewById(R.id.lvOrderDescriptionOptionList);

        lvOrderDescriptionList.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, orderDescriptionList));
        lvOrderOption.setAdapter(new OrdersDescriptionOptionListAdapter(getBaseContext(), orderDescriptionOptionList, orderDescriptionValuesList));
    }

    public void makeOrder(View v){
        Intent intent = new Intent(getBaseContext(), OrderMaker.class);
        startActivity(intent);
    }
}

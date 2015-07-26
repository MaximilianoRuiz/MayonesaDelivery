package com.example.maxi.mayonesadelivery;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.maxi.mayonesadelivery.dialogs.MyAddressListItemDialog;

import java.util.ArrayList;
import java.util.List;


public class MyAddress extends ActionBarActivity {

    ActionBar actionBar;
    ListView lvAddressList;
    List<String> addressList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ef0006")));

        lvAddressList = (ListView) findViewById(R.id.lvAddressList);
        addressList = new ArrayList<>();
        addressList.add("Caseros 827, 5to A Torre 2");
        addressList.add("Av Alem 3416");

        lvAddressList.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, addressList));

        lvAddressList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemDialog(view, addressList.get(position));
            }
        });
    }

    private void itemDialog(View v, String address){
        MyAddressListItemDialog myDialog = new MyAddressListItemDialog(address);
        myDialog.show(this.getFragmentManager(), "Dialog");
    }
}

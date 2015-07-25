package com.example.maxi.mayonesadelivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PrincipalMenu extends ActionBarActivity {

    ListView lvLeftOptionList, lvPrincipalList;
    ActionBar actionBar;
    List<String> optionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Mayonesa");

        lvLeftOptionList = (ListView) findViewById(R.id.leftOptionList);
        lvPrincipalList = (ListView) findViewById(R.id.principalList);

        optionList = new ArrayList<>();
        optionList.add("Locales");
        optionList.add("Mis Direcciones");
        optionList.add("Mis Pedidos");
        optionList.add("Mi Perfil");
        lvLeftOptionList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, optionList));

        List<String> listPrincipal = new ArrayList<>();
        listPrincipal.add("$100");
        listPrincipal.add("$150");
        lvPrincipalList.setAdapter(new PrincipalListAdapter(this, listPrincipal));

        lvLeftOptionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(getBaseContext(), Locals.class);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), MyAddresses.class);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(), MyOrders.class);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(), MyProfile.class);
                        break;
                }
                startActivity(intent);
            }
        });

        lvPrincipalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemDialog(view);
            }
        });
    }

    private void itemDialog(View v){
        PrincipalListItemDialog myDialog = new PrincipalListItemDialog("");
        myDialog.show(this.getFragmentManager(), "Dialog");
    }

    public void makeOrder(View v){
        Intent intent = new Intent(getBaseContext(), OrderDescription.class);
        startActivity(intent);
    }
}

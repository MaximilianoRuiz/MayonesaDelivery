package com.example.maxi.mayonesadelivery.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maxi.mayonesadelivery.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrderListItemDialog extends DialogFragment {

    String value;
    TextView pay;
    ListView lvOrderItemList;

    public MyOrderListItemDialog(String value){
        this.value = value;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.my_order_list_item, null);

        List<String> values = new ArrayList<>();
        values.add("$140");
        values.add("$150");

        pay = (TextView) view.findViewById(R.id.textView22);
        lvOrderItemList = (ListView) view.findViewById(R.id.lvOrderItemList);
        lvOrderItemList.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values));
        pay.setText(value);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setTitle("Direccion");

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancelar", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(), "Aceptar", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

}

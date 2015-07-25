package com.example.maxi.mayonesadelivery;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PrincipalListItemDialog extends DialogFragment {

    String payValue;
    Spinner spinner;

    public PrincipalListItemDialog(String payValue){
        this.payValue = payValue;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.principal_list_item, null);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>
                (getActivity(), android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_item);

        spinner.setAdapter(dataAdapter);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setTitle("Comida");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
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

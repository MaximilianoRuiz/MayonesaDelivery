package com.example.maxi.mayonesadelivery.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maxi.mayonesadelivery.R;

public class PrincipalListItemDialog extends DialogFragment {

    String payValue;
    Button btnLess, btnMore;
    EditText etCount;

    public PrincipalListItemDialog(String payValue){
        this.payValue = payValue;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.principal_list_item, null);

        btnLess = (Button) view.findViewById(R.id.btnLess);
        btnMore = (Button) view.findViewById(R.id.btnMore);
        etCount = (EditText) view.findViewById(R.id.etCount);

        etCount.setEnabled(false);

        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("0".equals(etCount.getText().toString())){
                    etCount.setText("10");
                } else {
                    Integer integer = Integer.parseInt(etCount.getText().toString());
                    etCount.setText(Integer.toString(integer-1));
                }
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("10".equals(etCount.getText().toString())){
                    etCount.setText("0");
                } else {
                    Integer integer = Integer.parseInt(etCount.getText().toString());
                    etCount.setText(Integer.toString(integer+1));
                }
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        return builder.create();
    }

}

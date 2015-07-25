package com.example.maxi.mayonesadelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends ActionBarActivity {
    EditText user, pass;
    Button login;
    Activity activity;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;

        actionBar = getSupportActionBar();
        actionBar.hide();

        user = (EditText) findViewById(R.id.etUser);
        pass = (EditText) findViewById(R.id.etPassword);
        login = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (user.getText().toString().equals("super")){
//                    if (!pass.getText().toString().equals("")){
                        Intent intent = new Intent(getBaseContext(), PrincipalMenu.class);
                        startActivity(intent);
                        activity.finish();
//                    }
//                } else {
//                    Toast.makeText(getBaseContext(), "Invalid User", Toast.LENGTH_LONG).show();
//                }
            }
        });
    }



}

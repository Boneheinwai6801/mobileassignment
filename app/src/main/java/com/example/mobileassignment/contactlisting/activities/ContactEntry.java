package com.example.mobileassignment.contactlisting.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.example.mobileassignment.R;
import com.example.mobileassignment.contactlisting.utils.Constants;


public class ContactEntry extends AppCompatActivity {

    private EditText txtfoodname, txtgroup, txtdate, txttype,txtnote,txtname;
    private AppCompatButton btnadd, btncancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_entry);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );
        initialize();
        actionInitializer();
    }

    private void initialize(){
        txtfoodname = (EditText) findViewById(R.id.txtfoodname);
        txtgroup = (EditText) findViewById(R.id.txtgroup);
        txtdate = (EditText) findViewById(R.id.txtdate);
        txttype = (EditText) findViewById(R.id.txttype);
        txtnote = (EditText) findViewById(R.id.txtnote);
        txttype = (EditText) findViewById(R.id.txtname);
        btnadd = (AppCompatButton) findViewById(R.id.btnadd);
        btncancel = (AppCompatButton) findViewById(R.id.btncancel);

    }

    private void actionInitializer(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isValid()){
                    Intent state = new Intent(getBaseContext(), ContactDisplay.class );
                    state.putExtra(Constants.FOODNAME , txtfoodname.getText().toString().trim() );
                    state.putExtra( Constants.FOODGROUP, txtgroup.getText().toString().trim() );
                    state.putExtra( Constants.DATE, txtdate.getText().toString().trim() );
                    state.putExtra( Constants.MAILTYPE, txttype.getText().toString().trim() );
                    state.putExtra( Constants.NOTE, txtnote.getText().toString().trim() );
                    state.putExtra( Constants.NAME, txtname.getText().toString().trim() );

                    setResult( RESULT_OK, state );
                    finish();
                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean isValid(){

        if( txtfoodname.getText().toString().trim().isEmpty() || txtfoodname.getText() == null ){
            Snackbar.make( txtfoodname, "Please enter name", Snackbar.LENGTH_LONG).show();
            txtfoodname.requestFocus();
            return false;
        }

        if( txtgroup.getText().toString().trim().isEmpty() || txtgroup.getText() == null ){
            Snackbar.make( txtgroup, "Please enter phone", Snackbar.LENGTH_LONG).show();
            txtgroup.requestFocus();
            return false;
        }

        if( txtdate.getText().toString().trim().isEmpty() || txtdate.getText() == null ){
            Snackbar.make( txtdate, "Please enter email", Snackbar.LENGTH_LONG).show();
            txtdate.requestFocus();
            return false;
        }

        if( txttype.getText().toString().trim().isEmpty() || txttype.getText() == null ){
            Snackbar.make( txttype, "Please enter address", Snackbar.LENGTH_LONG).show();
            txttype.requestFocus();
            return false;
        }
        if( txtnote.getText().toString().trim().isEmpty() || txtnote.getText() == null ){
            Snackbar.make( txtnote, "Please enter address", Snackbar.LENGTH_LONG).show();
            txtnote.requestFocus();
            return false;
        }
        if( txtname.getText().toString().trim().isEmpty() || txtname.getText() == null ){
            Snackbar.make( txtname, "Please enter address", Snackbar.LENGTH_LONG).show();
            txtname.requestFocus();
            return false;
        }


        return true;
    }

}

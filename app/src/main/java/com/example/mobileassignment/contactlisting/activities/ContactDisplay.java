package com.example.mobileassignment.contactlisting.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mobileassignment.R;
import com.example.mobileassignment.contactlisting.utils.Constants;


public class ContactDisplay extends AppCompatActivity {

    private TextView txtgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );

        txtgroup = (TextView) findViewById(R.id.txtgroup);

        Bundle bundle = getIntent( ).getExtras( );
        if( bundle!= null && bundle.getString(Constants.FOODGROUP) != null ){
            ((TextView)findViewById(R.id.txtfoodname)).setText( bundle.getString(Constants.FOODNAME) );
            txtgroup.setText( bundle.getString(Constants.FOODGROUP) );
            ((TextView)findViewById(R.id.txtdate)).setText( bundle.getString(Constants.DATE) );
            ((TextView)findViewById(R.id.txttype)).setText( bundle.getString(Constants.MAILTYPE) );
            ((TextView)findViewById(R.id.txtnote)).setText( bundle.getString(Constants.NOTE) );
            ((TextView)findViewById(R.id.txtname)).setText( bundle.getString(Constants.NAME) );

        }
    }

}

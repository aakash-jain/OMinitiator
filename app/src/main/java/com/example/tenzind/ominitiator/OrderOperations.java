package com.example.tenzind.ominitiator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tenzind on 11/29/2017.
 */
public class OrderOperations extends AppCompatActivity{
    EditText cancelEdit;
    EditText forceEdit;
    public static final String CANCEL="http://10.100.160.221:9009/omapi/order/cancel/orderId/";
    public static final String FORCE_CLOSE="http://10.100.160.221:9009/omapi/order/forceClose/orderId/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderoperations);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button forceclose = (Button) findViewById(R.id.forceclose);
        cancelEdit=(EditText)findViewById(R.id.canceledittext);
        forceEdit=(EditText)findViewById(R.id.forceedittext);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = cancelEdit.getText().toString();
                String newUrl=CANCEL+str;
                new AsyncCallPOST().execute(newUrl);
                String status = System.getProperty("status");
                String orderId = System.getProperty("orderId");
                String finalOne=orderId+","+status;
                Toast.makeText(getApplicationContext(),finalOne,Toast.LENGTH_LONG).show();
            }
        });
        forceclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = forceEdit.getText().toString();
                String newUrl=FORCE_CLOSE+str;
                new AsyncCallPOST().execute(newUrl);
            }
        });
    }
}

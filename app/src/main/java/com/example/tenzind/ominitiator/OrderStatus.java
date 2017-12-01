package com.example.tenzind.ominitiator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tenzind on 11/29/2017.
 */

public class OrderStatus extends AppCompatActivity {

    private static final String ORDER_STATUS="http://10.100.160.221:9009/omapi/order/status/orderId/";
    EditText orderstatusEditText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderstatus);
        Button orderstatusId = (Button) findViewById(R.id.orderstatusid);
        Button orderstatusall = (Button) findViewById(R.id.orderstatusall);
        orderstatusEditText=(EditText)findViewById(R.id.orderstatusEditText);
        orderstatusId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = orderstatusEditText.getText().toString();
                String newUrl=ORDER_STATUS+str;
                new AsyncCallPOST().execute(newUrl);
                String status = System.getProperty("status");
                String orderId = System.getProperty("orderId");
                String finalOne=orderId+","+status;
                Toast.makeText(getApplicationContext(),finalOne,Toast.LENGTH_LONG).show();
            }
        });
        orderstatusall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentWelcome=new Intent(OrderStatus.this,OrderStatusAllOrderIds.class);
                startActivity(intentWelcome);
            }
        });
    }
}

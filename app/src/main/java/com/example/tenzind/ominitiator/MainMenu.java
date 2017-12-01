package com.example.tenzind.ominitiator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Created by tenzind on 11/29/2017.
 */

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        Button server = (Button) findViewById(R.id.server);
        Button orderstatus = (Button) findViewById(R.id.orderstatus);
        Button orderOperations = (Button) findViewById(R.id.operations);
        Button killProcess = (Button) findViewById(R.id.applicationLogButton);
        server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentWelcome=new Intent(MainMenu.this,Server.class);
                startActivity(intentWelcome);

            }
        });
        orderstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentWelcome=new Intent(MainMenu.this,OrderStatus.class);
                startActivity(intentWelcome);

            }
        });
        orderOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentWelcome=new Intent(MainMenu.this,OrderOperations.class);
                startActivity(intentWelcome);
            }
        });
        killProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // new AsyncCallGET().execute(KILL_PROCESS);
            }
        });
    }
}

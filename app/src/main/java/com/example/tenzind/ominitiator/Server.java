package com.example.tenzind.ominitiator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 *  Created by TenzinD on 11/6/2017.
 *  This class will hit APIs and initiate OM.
 */
public class Server extends AppCompatActivity{
    private final Utility utility=Utility.INSTANCE;
    private static final String START_API="http://10.100.160.221:8080/initiator/start";
    private static final String STOP_API="http://10.100.160.221:8080/initiator/stop";
    private static final String CLEAN_RESTART_API="http://10.100.160.221:8080/initiator/cleanRestart";
    private static final String KILL_PROCESS="http://10.100.160.221:8080/initiator/killProcess";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server);
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopbutton);
        Button cleanRestartButton = (Button) findViewById(R.id.cleanrestart);
        Button killProcess = (Button) findViewById(R.id.killprocess);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncCallGET().execute(START_API);
                String status = System.getProperty("started");
                Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncCallGET().execute(STOP_API);
                String status = System.getProperty("stopped");
                Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();
            }
        });
        cleanRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncCallGET().execute(CLEAN_RESTART_API);
                String status = System.getProperty("cleanRestarted");
                Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();
            }
        });
        killProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncCallGET().execute(KILL_PROCESS);
                String status = System.getProperty("killed process");
                Toast.makeText(getApplicationContext(),status,Toast.LENGTH_LONG).show();
            }
        });
    }
}


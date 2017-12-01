package com.example.tenzind.ominitiator;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;


/**
 * Main class.
 */
public class MainActivity extends AppCompatActivity {

  private Button welcomeButton;
   // private Tracker tracker;
    private TextToSpeech textToSpeech;
    private final Utility utility=Utility.INSTANCE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       welcomeButton=(Button)findViewById(R.id.welcomeButton);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.CANADA);
                    textToSpeech.setSpeechRate(0.8f);
                }
            }
        });
        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //textToSpeech.speak("welcome to OM control",TextToSpeech.QUEUE_FLUSH,null);
                    final Intent intentWelcome=new Intent(MainActivity.this,MainMenu.class);
                    startActivity(intentWelcome);
                    Log.e("my app","the your message will go here");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

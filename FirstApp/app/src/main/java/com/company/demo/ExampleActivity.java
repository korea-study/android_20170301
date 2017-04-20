package com.company.demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExampleActivity extends AppCompatActivity {
    private Button toastButton = null;
    private Button naverButton = null;
    private Button telButton = null;
    private Button startButton = null;
    private Button stopButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        toastButton = (Button) findViewById(R.id.toast_button);
        naverButton = (Button) findViewById(R.id.intent_uri_button);
        telButton = (Button) findViewById(R.id.intent_tel_button);
        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);


        toastButton.setOnClickListener(mClickListener);
        naverButton.setOnClickListener(mClickListener);
        telButton.setOnClickListener(mClickListener);
        startButton.setOnClickListener(mClickListener);
        stopButton.setOnClickListener(mClickListener);

    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.toast_button :
                    Log.d("KKK", "Test");
                    Toast.makeText(getApplicationContext(), "Hi Hello", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.intent_uri_button :
                    Intent uri_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.m.naver.com"));
                    startActivity(uri_intent);
                    break;
                case R.id.intent_tel_button :
                    Intent tel_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-3733-0925"));
                    startActivity(tel_intent);
                    break;
                case R.id.start_button :
                    Log.d("KKK", "Test");
                    Toast.makeText(getApplicationContext(), "START", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.stop_button :
                    Log.d("KKK", "Test");
                    Toast.makeText(getApplicationContext(), "STOP", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}

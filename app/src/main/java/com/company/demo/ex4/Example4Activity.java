package com.company.demo.ex4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.company.demo.R;

public class Example4Activity extends AppCompatActivity {

    ImageView playButton  = null;
    ImageView tempStopButton = null;
    ImageView stopButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        playButton = (ImageView) findViewById(R.id.music_play_button);
        tempStopButton = (ImageView) findViewById(R.id.music_temp_stop_button);
        stopButton = (ImageView) findViewById(R.id.music_stop_button);

        playButton.setOnClickListener(mClickListener);
        tempStopButton.setOnClickListener(mClickListener);
        stopButton.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent serviceIntent = new Intent("com.company.demo.ex4.Example4Service");
            switch (v.getId()){
                case R.id.music_play_button :
                    serviceIntent.setPackage("com.company.demo");
                    serviceIntent.putExtra("whatButton", "startButton");
                    startService(serviceIntent);
                    break;
                case R.id.music_temp_stop_button :
                    serviceIntent.setPackage("com.company.demo");
                    serviceIntent.putExtra("whatButton", "tempStopButton");
                    startService(serviceIntent);
                    break;
                case R.id.music_stop_button :
                    serviceIntent.setPackage("com.company.demo");
                    serviceIntent.putExtra("whatButton", "stopButton");
                    startService(serviceIntent);
                    break;
            }
        }
    };
}


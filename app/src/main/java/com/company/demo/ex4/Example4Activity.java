package com.company.demo.ex4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.company.demo.R;

public class Example4Activity extends AppCompatActivity {

    ImageView playButton  = null;
    ImageView stopButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example4);
        playButton = (ImageView) findViewById(R.id.music_play_button);
        stopButton = (ImageView) findViewById(R.id.music_stop_button);

        playButton.setOnClickListener(mClickListener);
        stopButton.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.music_play_button :
                    Intent serviceIntent = new Intent("com.company.demo.ex4.Example4Service");
                    serviceIntent.setPackage("com.company.demo");
                    serviceIntent.putExtra("startButton", "startButton");
                    startService(serviceIntent);
                    break;
                case R.id.music_stop_button :
                    break;
            }
        }
    };
}


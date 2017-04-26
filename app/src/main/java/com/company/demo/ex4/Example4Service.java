package com.company.demo.ex4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.company.demo.R;

public class Example4Service extends Service {
    private String TAG = "Example4Service";

    MediaPlayer mediaPlayer = null;
    public Example4Service() {
        Log.d(TAG, "Example4Service constructor()");
    }

    @Override
    public void onCreate() { // Service 최초 실행시 호출
        super.onCreate();
        Log.d(TAG, "onCreate()");
        mediaPlayer = MediaPlayer.create(this, R.raw.dubstep);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { // Service 실행 이후에 재 호출 시 호출하는 method
        Log.d(TAG, "onStartCommand()");

        if(intent.getStringExtra("startButton").equals("startButton")){
            try {
//                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.d(TAG, "onStartCommand() else");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

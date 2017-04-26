package com.company.demo.ex4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.company.demo.R;

public class Example4Service extends Service {
    private String TAG = "Example4Service";

    int pauseTime = 0;
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

        Log.d(TAG, "intent.getStringExtra(\"startButton\") : " + intent.getStringExtra("startButton"));
        Log.d(TAG, "intent.getStringExtra(\"tempStopButton\") : " + intent.getStringExtra("tempStopButton"));
        Log.d(TAG, "intent.getStringExtra(\"stopButton\") : " + intent.getStringExtra("stopButton"));

        if(intent.getStringExtra("whatButton").equals("startButton")){
            if(pauseTime==0){ // 처음부터 실행
                mediaPlayer.start();
            } else { // pause 이후에 실행
                mediaPlayer.seekTo(pauseTime);
                mediaPlayer.start();
            }
        } else if(intent.getStringExtra("whatButton").equals("tempStopButton")){
            mediaPlayer.pause();
            pauseTime = mediaPlayer.getCurrentPosition();
            Log.d(TAG, "pauseTime-pause() : " + pauseTime);
        } else if(intent.getStringExtra("whatButton").equals("stopButton")){
            mediaPlayer.stop();
            pauseTime = 0;
            Log.d(TAG, "pauseTime-stop() : " + pauseTime);
        } else {
            Log.d(TAG, "onStartCommand() else");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

package com.company.demo.ex4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Example4Service extends Service {
    private String TAG = "Example4Service";
    public Example4Service() {
    }

    @Override
    public void onCreate() { // Service 최초 실행시 호출
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { // Service 실행 이후에 재 호출 시 호출하는 method
        Log.d(TAG, "onStartCommand()");
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

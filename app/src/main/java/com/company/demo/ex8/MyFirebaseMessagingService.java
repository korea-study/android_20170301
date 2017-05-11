package com.company.demo.ex8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyFirebaseMessagingService extends Service {
    public MyFirebaseMessagingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

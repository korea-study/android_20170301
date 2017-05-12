package com.company.demo.ex8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.company.demo.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class Example8Activity extends AppCompatActivity {
    private String TAG = "Example8Activity";
    private String fcmToken = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example8);

        fcmToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "fcmToken : " + fcmToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(fcmToken);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
//        FCM 서버가 아닌 서비스 앱 서버로 토큰을 보내는 메소드
    }
}

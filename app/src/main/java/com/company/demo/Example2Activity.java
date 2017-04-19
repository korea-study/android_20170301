package com.company.demo;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Example2Activity extends AppCompatActivity {

    private Button intentTestButton = null;
    private Button receiverTestButton = null;
    private Button broadcaseTestButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        intentTestButton = (Button) findViewById(R.id.ex_intent_button);
        receiverTestButton = (Button) findViewById(R.id.ex_receiver_button);
        broadcaseTestButton = (Button) findViewById(R.id.ex_broadcast_button);

        intentTestButton.setOnClickListener(mClickListener);
        receiverTestButton.setOnClickListener(mClickListener);
        broadcaseTestButton.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ex_intent_button :
                    Log.d("KKKK", "onClick() : ex_intent_button"); // 명시적 인텐트
                    Intent testIntent = new Intent();
                    ComponentName componentName = new ComponentName("com.hunt.lab.huntlab_client", "com.hunt.lab.huntlab_client.view.activity.IntroActivity"); // 다른 app 선택 Component
                    testIntent.setComponent(componentName);

//                    Intent testIntent2 = new Intent(this, ~~Activity.class);
//                    startActivity(testIntent2);
                    startActivity(testIntent);
                    break;
                case R.id.ex_receiver_button :
                    Log.d("KKKK", "onClick() : ex_receiver_button"); // 암시적 인텐트
                    Intent implIntnet = new Intent();
//                    implIntnet.setAction(Intent.ACTION_MAIN);
//                    implIntnet.addCategory(Intent.CATEGORY_APP_MAPS); // X
//                    implIntnet.addCategory(Intent.CATEGORY_APP_CALENDAR); // O
//                    implIntnet.addCategory(Intent.CATEGORY_APP_EMAIL); // O
//                    implIntnet.addCategory(Intent.CATEGORY_APP_GALLERY); // O
//                    implIntnet.addCategory(Intent.CATEGORY_APP_CONTACTS); // O

                    implIntnet.setAction("action.ACTION_HUNT_CLIENT"); // Call custom impl Activity

                    startActivity(implIntnet);
                    break;
                case R.id.ex_broadcast_button :
                    Log.d("KKKK", "onClick() : ex_broadcast_button");
                    Intent broadIntent = new Intent();
                    broadIntent.setAction("action.ACTION_HUNT_CLIENT");
                    broadIntent.putExtra("message", "This message come from koreastudy");
                    sendBroadcast(broadIntent);
                    break;
            }
        }
    };
}

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        intentTestButton = (Button) findViewById(R.id.ex_intent_button);
        receiverTestButton = (Button) findViewById(R.id.ex_receiver_button);

        intentTestButton.setOnClickListener(mClickListener);
        receiverTestButton.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ex_intent_button :
                    Log.d("KKKK", "onClick() : ex_intent_button");
                    Intent testIntent = new Intent();
                    ComponentName componentName = new ComponentName("com.hunt.lab.huntlab_client", "com.hunt.lab.huntlab_client.view.activity.IntroActivity");
                    testIntent.setComponent(componentName);
                    startActivity(testIntent);
                    break;
                case R.id.ex_receiver_button :
                    Log.d("KKKK", "onClick() : ex_receiver_button");

                    break;
            }
        }
    };
}

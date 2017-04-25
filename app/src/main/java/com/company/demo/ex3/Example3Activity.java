package com.company.demo.ex3;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.company.demo.R;

public class Example3Activity extends AppCompatActivity {

    TextView threadTextViewCount = null;
    TextView threadTextViewGetCnt = null;
    Button threadStartButton = null;
    Button threadButton = null;

    int threadCnt = 0;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);

        threadTextViewCount = (TextView) findViewById(R.id.thread_count);
        threadTextViewGetCnt = (TextView) findViewById(R.id.thread_get_count);
        threadStartButton = (Button) findViewById(R.id.thread_start_button);
        threadButton = (Button) findViewById(R.id.thread_button);

        threadStartButton.setOnClickListener(mClickListener);
        threadButton.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.thread_start_button :
                    Thread countThread = new Thread(){
                        public void run(){
                            for(int i = 0 ; i < 10 ; i++){

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        threadTextViewCount.setText("Current Count : " + threadCnt);
                                    }
                                });
                                threadCnt += 1;
                                Log.d("kkkk", "threadCnt(" + threadCnt + ")");
                                try{
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    };

                    countThread.start();
                    break;
                case R.id.thread_button :
                    threadTextViewGetCnt.setText("" + threadTextViewCount.getText());
                    break;
            }
        }
    };

}

package com.company.demo.ex3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.company.demo.R;

import static com.company.demo.R.id.thread_progress_bar;

public class Example3Activity extends AppCompatActivity {

    TextView threadTextViewCount = null;
    TextView threadTextViewGetCnt = null;
    Button threadStartButton = null;
    Button threadButton = null;
    Button threadProgressButton = null;
    ProgressBar threadProgressBar = null;

    int threadCnt = 0;

    Handler handler = new Handler();
    ProgressHandler pHandler = new ProgressHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);

        threadTextViewCount = (TextView) findViewById(R.id.thread_count);
        threadTextViewGetCnt = (TextView) findViewById(R.id.thread_get_count);
        threadStartButton = (Button) findViewById(R.id.thread_start_button);
        threadButton = (Button) findViewById(R.id.thread_button);
        threadProgressButton = (Button)findViewById(R.id.thread_progress_button);
        threadProgressBar = (ProgressBar) findViewById(thread_progress_bar);

        threadStartButton.setOnClickListener(mClickListener);
        threadButton.setOnClickListener(mClickListener);
        threadProgressButton.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.thread_start_button:
                    Thread countThread = new Thread() {
                        public void run() {
                            for (int i = 0; i < 10; i++) {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        threadTextViewCount.setText("Current Count : " + threadCnt);
                                    }

                                });
                                threadCnt += 1;
                                Log.d("kkkk", "threadCnt(" + threadCnt + ")");
                            }

                        }
                    };

                    countThread.start();
                    break;
                case R.id.thread_button:
                    threadTextViewGetCnt.setText("" + threadTextViewCount.getText());
                    break;

                case R.id.thread_progress_button:
                    threadProgressBar.setProgress(0);

                    Thread pThread = new Thread(){
                        public void run(){
                            for (int i = 0; i < 10; i++) {
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        threadProgressBar.incrementProgressBy(10);
                                    }
                                });
                            }

                        }
                    };
                    pThread.start();
                    break;
            }

        }
    };


    public class ProgressHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


        }
    }

}

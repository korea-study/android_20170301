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
    Button threadProgressButton2 = null;
    ProgressBar threadProgressBar2 = null;

    int threadCnt = 0;

    Handler handler = new Handler();
    Handler handler2 = new Handler();
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
        threadProgressButton2 = (Button) findViewById(R.id.thread_progress_button2);
        threadProgressBar2 = (ProgressBar) findViewById(R.id.thread_progress_bar2);

        threadStartButton.setOnClickListener(mClickListener);
        threadButton.setOnClickListener(mClickListener);
        threadProgressButton.setOnClickListener(mClickListener);
        threadProgressButton2.setOnClickListener(mClickListener);
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
                                        Log.d("kkkk", "run(" + threadCnt + ")");
                                        threadTextViewCount.setText("Current Count- : " + threadCnt);
                                    }

                                });
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("kkkk", "run(" + threadCnt + ")");
                                        threadTextViewCount.setText("Current Count-- : " + threadCnt);
                                    }

                                });
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("kkkk", "run(" + threadCnt + ")");
                                        threadTextViewCount.setText("Current Count--- : " + threadCnt);
                                    }

                                });
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Log.d("kkkk", "run(" + threadCnt + ")");
                                        threadTextViewCount.setText("Current Count---- : " + threadCnt);
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

                case R.id.thread_progress_button2 :
                    // Message 사용
                    threadProgressBar2.setProgress(0);

                    Thread p2Thread = new Thread(){
                        public void run(){
                            for(int i = 0 ; i < 10; i++){
                                Log.d("kkkk", "for() i : " + i);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Message message = pHandler.obtainMessage();
                                message.what = 1;
                                message.arg1 = 2;
                                message.obj = new Object();

                                pHandler.sendMessage(message);
                            }
                        }
                    };
                    p2Thread.start();
                    break;
            }
        }
    };


    public class ProgressHandler extends Handler{ // 화면 작업에 특정 작업 적용시 컨트롤하기 위해서 Handler 상속 클래스 생성
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Object object = msg.obj;
            Log.d("kkkk", "ProgressHandler : " + msg.what + ", " + msg.arg1 + ", " + object.toString());

            threadProgressBar2.incrementProgressBy(10);
        }
    }

}

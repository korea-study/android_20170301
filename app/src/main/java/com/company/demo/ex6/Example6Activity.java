package com.company.demo.ex6;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.company.demo.R;

public class Example6Activity extends AppCompatActivity {

    private ImageView imageView = null;
    Handler mHandler = new Handler();
    boolean animationGoStop = true;
    int animationNumber = 0;

    // I/Choreographer(1378): Skipped 55 frames!  The application may be doing too much work on its main thread.
    // image source file size over 1MB > modify_ 200KB
    final int[] animationImageList = {R.drawable.ex_frame_01,
            R.drawable.modify_ex_frame_02,
            R.drawable.modify_ex_frame_03,
            R.drawable.modify_ex_frame_04,
            R.drawable.modify_ex_frame_05,
            R.drawable.modify_ex_frame_06,
            R.drawable.modify_ex_frame_07,
            R.drawable.modify_ex_frame_08,
            R.drawable.modify_ex_frame_09,
            R.drawable.modify_ex_frame_10,
            R.drawable.modify_ex_frame_11,
            R.drawable.modify_ex_frame_12,
            R.drawable.modify_ex_frame_13,
            R.drawable.modify_ex_frame_14,
    };



//    tweened animation
    private ImageView tweenedImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example6);

        imageView = (ImageView) findViewById(R.id.anim_image_view);
        imageView.setRotation(180);

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (animationGoStop){
                    synchronized (this){
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageResource(animationImageList[animationNumber]);
                            }
                        });
                        Log.d("kkkk", "animationNumber : " + animationNumber);
                        if(animationNumber==13){
                            animationNumber = 0;
                        } else {
                            animationNumber += 1;
                        }
                        try{
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        thread.start();


//        tweened
        tweenedImageView = (ImageView) findViewById(R.id.tweened_anim_image_view);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_images);
        tweenedImageView.startAnimation(animation);

    }


}

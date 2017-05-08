package com.company.demo.ex1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.company.demo.R;

public class ExampleActivity extends AppCompatActivity {

    private Button changeButton = null;
    private Button naverButton = null;
    private Button telButton = null;
    private Button startButton = null;
    private Button stopButton = null;

    private FrameLayout frameLayout = null;
    private ImageView imageViewOne = null;
    private ImageView imageViewTwo = null;

    private int toggleFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        changeButton = (Button) findViewById(R.id.change_button);
        naverButton = (Button) findViewById(R.id.naver_button);
        telButton = (Button) findViewById(R.id.tel_button);
        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        frameLayout = (FrameLayout) findViewById(R.id.frame_button);
        imageViewOne = (ImageView) findViewById(R.id.image_button_one);
        imageViewTwo = (ImageView) findViewById(R.id.image_button_two);


        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CHANGE!", Toast.LENGTH_SHORT).show();
            }
        });
        naverButton.setOnClickListener(mClickListener);
        telButton.setOnClickListener(mClickListener);
        startButton.setOnClickListener(mClickListener);
        stopButton.setOnClickListener(mClickListener);
        frameLayout.setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.naver_button :
                    Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                    startActivity(naverIntent);
                    break;
                case R.id.tel_button :
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01037330925")));
                    break;
                case R.id.start_button :
                    Toast.makeText(getApplicationContext(), "START", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.stop_button :
                    Toast.makeText(getApplicationContext(), "STOP", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.frame_button :
                    if(toggleFlag==0){
                        imageViewOne.setVisibility(View.VISIBLE);
                        imageViewTwo.setVisibility(View.GONE);
                        toggleFlag = 1;
                    } else {
                        imageViewOne.setVisibility(View.GONE);
                        imageViewTwo.setVisibility(View.VISIBLE);
                        toggleFlag = 0;
                    }
                    break;
            }
        }
    };
}

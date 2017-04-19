package com.example.administrator.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButton1Clicked(View v){
        finish();
        Toast.makeText(this,"이전화면으로 이동합니다.",Toast.LENGTH_LONG).show();
    }

}

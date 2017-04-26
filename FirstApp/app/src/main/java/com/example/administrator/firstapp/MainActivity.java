package com.example.administrator.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent(this, PreferencesActivity.class);
        startActivity(intent);
    }

    public void onButton2Clicked(View v){
        Intent intent = new Intent(this, FilesActivity.class);
        startActivity(intent);
    }

    public void onButton3Clicked(View v){
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }


}

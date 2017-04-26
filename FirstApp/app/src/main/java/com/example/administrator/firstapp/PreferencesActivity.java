package com.example.administrator.firstapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    EditText editText;
    static int NUMBER = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        editText = (EditText)findViewById(R.id.editText);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause 호출됨", Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("test", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit(); //에디터가 저장하는것
        editor.putString("msg",editText.getText().toString());
        editor.putInt("number",NUMBER++);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume 호출됨", Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("test", Activity.MODE_PRIVATE);
        String msg = pref.getString("msg","문자를 입력해주세요");//데이터가 없으면 뒤에것으로 값이 들어감
        editText.setText(msg);
        int count = pref.getInt("number",0);
        if(count>0){
            NUMBER=count+1;
        }
        Toast.makeText(getApplicationContext(),"접속한 수 : "+NUMBER, Toast.LENGTH_LONG).show();
    }

    public void onButton1Clicked(View v){
        finish();
        Toast.makeText(this,"이전화면으로 이동합니다.",Toast.LENGTH_LONG).show();
    }

}

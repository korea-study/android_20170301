
package com.example.administrator.firstapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FilesActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    TextView textView2;
    String state; //외부 저장장치 상태

    static final String FILE_NAME = "myFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
    }

    public void onButton1Clicked(View v){

        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            String str = editText.getText().toString()+"\n";
            fos.write(str.getBytes());
            fos.close();
            Toast.makeText(this,"저장되었습니다. ",Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void onButton2Clicked(View v){

        try {
            StringBuffer data = new StringBuffer();

            FileInputStream fis = openFileInput(FILE_NAME);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(fis));
            String str = buffer.readLine();

            while(str != null){
                data.append(str+"\n");
                str = buffer.readLine();
            }
            textView.setText(data);
            buffer.close();
            fis.close();
            Toast.makeText(this,"파일을 불러왔습니다.",Toast.LENGTH_LONG).show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void onButton3Clicked(View v){
        if(!checkExternalStorage()){ return; }//외부메모리 사용할 수 없다.

        String data = editText.getText().toString()+"\n";

        try {
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File saveFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "externalTest.txt");
            if(!path.exists()){
                path.mkdir();
                Log.d("TEST","path에 폴더 없는 경우 생성함..");
            }
            if(!saveFile.mkdir()){
                Log.d("TEST","디렉토리가 생성되지 않음...");
            }

            FileWriter write = new FileWriter(saveFile,false);
            PrintWriter pw = new PrintWriter(write);
            pw.println(data);
            pw.close();
            textView2.setText("저장완료");
            Log.d("TEST","저장내용 : "+data);
            Log.d("TEST","저장완료");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onButton4Clicked(View v){

        if(!checkExternalStorage()){return;}

        StringBuffer data = new StringBuffer();
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File savedFile = new File(path,"externalText.txt");

        try {

            FileReader in = new FileReader(savedFile);
            BufferedReader reader = new BufferedReader(in);

            String str = reader.readLine();

            while (str!=null){
                data.append(str+"\n");
                str = reader.readLine();
            }

            textView2.setText(data);
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /*
    외부메모리 상태 확인 메서드
    */
    private boolean checkExternalStorage(){

        state = Environment.getExternalStorageState(); //외부메모리 상태
        if(Environment.MEDIA_MOUNTED.equals(state)){
            //읽기 쓰기 모두 가능
            Log.d("TEST","외부메모리 읽기 쓰기 가능");
            textView2.setText("외부메모리 읽기 쓰기 가능");
            return true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            //읽기 전용
            Log.d("TEST","외부메모리 읽기만 가능");
            textView2.setText("외부메모리 읽기만 가능");
            return false;
        }else{
            //읽기 쓰기 모두 불가
            Log.d("TEST","외부메모리 읽기쓰기 모두 안됨");
            textView2.setText("외부메모리 읽기 쓰기 모두 안됨");
            return false;
        }

    }
}

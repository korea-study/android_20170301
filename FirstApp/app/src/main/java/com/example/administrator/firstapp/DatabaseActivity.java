package com.example.administrator.firstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    TextView textView;

    SQLiteDatabase database;
    String databaseName;
    String tableName;
    String name;
    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        editText = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        textView = (TextView)findViewById(R.id.textView);

    }

    public void onButton1Clicked(View v){
        databaseName = editText.getText().toString();

        try {
            //데이터베이스 오픈 할것. 열어주거나 없으면 생성
            database = this.openOrCreateDatabase(databaseName, Context.MODE_PRIVATE,null);
            //저장공간이 만들어진 것입니다.

            Log.d("TEST","데이터베이스를 열었습니다. : "+databaseName);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void onButton2Clicked(View v){
        tableName = editText2.getText().toString();
        try {
            if(database != null){
                database.execSQL("CREATE TABLE if not exists "+ tableName + "("
                        + "_id integer PRIMARY KEY autoincrement, "
                        + "name text, "
                        + "age integer "
                        + ")");
                //내부적으로 관리하는 컬럼은 언더바를 사용해서 표기한다.
                Log.d("TEST","테이블을 만들었습니다. : "+tableName);
                //테이블도 마찬가지로 앱이 종료 됐다고 해도 사라지지 않는다.
            }else{
                Toast.makeText(getApplicationContext(),"데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_LONG).show();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void onButton3Clicked(View v){
        try {
            if (tableName == null){
                tableName = editText2.getText().toString();
            }
            if(database != null) {
                name = editText3.getText().toString();
                age = Integer.parseInt(editText4.getText().toString());
                database.execSQL("insert into " + tableName + " (name, age ) values ('"
                        + name + "' , " + age + " );");
                Toast.makeText(getApplicationContext(), "데이터를 저장했습니다.", Toast.LENGTH_LONG).show();
                editText3.setText("");
                editText4.setText("");
            }else{
                Toast.makeText(getApplicationContext(),"데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onButton4Clicked(View v){

        textView.setText("");
        try {
            if(tableName == null){
                tableName = editText2.getText().toString();
            }

            if(database !=null){
                Cursor cursor = database.rawQuery("select _id, name, age FROM "+tableName, null);
                int count = cursor.getCount();
                Log.d("TEST","cursor 갯수 : "+count);

                for (int i = 0; i< count; i++){
                    cursor.moveToNext();
                    String name = cursor.getString(1);
                    int age = cursor.getInt(2);

                    textView.append(i+ " : "+name+" , "+age+"\n");
                }

                cursor.close();

            }else{
                Toast.makeText(getApplicationContext(),"데이터베이스를 먼저 열어야 합니다.", Toast.LENGTH_LONG).show();
            }

        }catch(Exception e){
            e.printStackTrace();

        }
    }

}

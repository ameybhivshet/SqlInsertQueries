package com.example.amey.sqlinsert;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText username,password;
    String  usname,pswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= (EditText) findViewById(R.id.editText);
        password= (EditText) findViewById(R.id.editText2);

    }


    public void adduser(View view)
    {


Ameyadapter ameyadapter=new Ameyadapter(this);

        usname=username.getText().toString();
        pswd=username.getText().toString();


       long id= ameyadapter.insert(usname,pswd);


        if(id<0)
        {
            Message.message(this,"unsuccessfull");
        }
        else
        {
            Message.message(this,"successfull");
        }
    }
}

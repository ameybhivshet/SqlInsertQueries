package com.example.amey.sqlinsert;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by amey on 7/8/2016.
 */
public class Message  {

public static void message(Context context,String data){

        Toast.makeText(context,data,Toast.LENGTH_LONG).show();
    }
}

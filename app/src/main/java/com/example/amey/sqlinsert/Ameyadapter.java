package com.example.amey.sqlinsert;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLData;

/**
 * Created by amey on 7/8/2016.
 */


public class Ameyadapter {

    Ameyhelper helper;
   public  Ameyadapter(Context context)
   {
       helper=new Ameyhelper(context);
   }

public  long insert(String name,String password)
{
   SQLiteDatabase db= helper.getWritableDatabase();
    ContentValues contentValues=new ContentValues();
    contentValues.put(helper.USERNAME,name);
    contentValues.put(helper.PASSWORD,password);
   long id =db.insert(helper.DATABASE_TABLE,null,contentValues);
    return id;

}





   static class Ameyhelper extends SQLiteOpenHelper
    {
        Context context;

        private static String DATABASE_NAME="ameydatabase";
        private static String DATABASE_TABLE="AMEYTABLE";
        private static String USERNAME="USER_NAME";
        private static int DATABASE_VERSION=5;
        private static String UID="_id";
        private static String PASSWORD="PASSWORD";
        private static String CREATE_TABLE=" CREATE TABLE "+DATABASE_TABLE+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT," +USERNAME+ " VARCHAR(255)," +PASSWORD + " VARCHAR(255));";
        private static String DROP_TABLE="DROP TABLE IF EXISTS " +DATABASE_TABLE;
        public Ameyhelper(Context context) {


            super(context, DATABASE_NAME, null,DATABASE_VERSION );
            this.context=context;
            Message.message(context, "created constructir");

        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            try {
                db.execSQL(CREATE_TABLE);

                Message.message(context, "created database");

            } catch (SQLException e) {
                Message.message(context,""+e);
                Log.d("ab", " " + e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                Message.message(context, "upgraded database");

                onCreate(db);
            } catch (SQLException e) {
                Message.message(context,""+e);
                Log.d("ab", " " + e);
            }
        }


    }
}

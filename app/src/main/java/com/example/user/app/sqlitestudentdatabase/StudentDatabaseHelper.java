package com.example.user.app.sqlitestudentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arun on 23-01-2017.
 */
public class StudentDatabaseHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="StudentDB";
    private static final String TABLE_NAME = "Student";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRSTNAME = "firstname";
    private static final String COLUMN_LASTNAME = "lastname";
    private static final String COLUMN_TEACHERNAME= "teachername";
    private static final String COLUMN_ROLLNO="rollno";


   public StudentDatabaseHelper(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Student('"+COLUMN_ID+"' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,firstname VARCHAR,lastname VARCHAR,teachername VARCHAR,rollno VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertStudentInfo(String first_name,String last_name,String teacher_name,String roll_no){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_FIRSTNAME,first_name);
        values.put(COLUMN_LASTNAME,last_name);
        values.put(COLUMN_TEACHERNAME,teacher_name);
        values.put(COLUMN_ROLLNO,roll_no);

        //insert into database
        sqLiteDatabase.insert(TABLE_NAME,null,values);

    }

    public List<String> getAllStudentDetails(){
        List<String> list = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);//selectQuery,selectedArguments

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));
                list.add(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        // closing connection
        cursor.close();
        sqLiteDatabase.close();

        // returning student details
        return list;
    }


}


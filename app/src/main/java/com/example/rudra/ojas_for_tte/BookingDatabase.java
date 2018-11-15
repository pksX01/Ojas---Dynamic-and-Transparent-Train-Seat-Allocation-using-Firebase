package com.example.rudra.ojas_for_tte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookingDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Booking.db";
    public static final String Train1 = "Train_12561";
    public static final String Train2 = "Train_12562";
    public static final String Train3 = "Train_14013";
    public static final String Train4 = "Train_14014";
    public static final String Train5 = "Train_14017";
    public static final String Train6 = "Train_14018";

    public static final String COL_1 = "NAME";
    public static final String COL_2 = "AGE";
    public static final String COL_3 = "SEX";
    public static final String COL_4 = "MOBILE_NO";
    public static final String COL_5 = "COACH_NO";
    public static final String COL_6 = "SEAT_NO";

    public BookingDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Train1 +" (NAME TEXT,AGE TEXT,SEX TEXT,MOBILE_NO TEXT, COACH_NO TEXT, SEAT_NO INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table " + Train2 +" (NAME TEXT,AGE TEXT,SEX TEXT,MOBILE_NO TEXT, COACH_NO TEXT, SEAT_NO INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table " + Train3 +" (NAME TEXT,AGE TEXT,SEX TEXT,MOBILE_NO TEXT, COACH_NO TEXT, SEAT_NO INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table " + Train4 +" (NAME TEXT,AGE TEXT,SEX TEXT,MOBILE_NO TEXT, COACH_NO TEXT, SEAT_NO INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table " + Train5 +" (NAME TEXT,AGE TEXT,SEX TEXT,MOBILE_NO TEXT, COACH_NO TEXT, SEAT_NO INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("create table " + Train6 +" (NAME TEXT,AGE TEXT,SEX TEXT,MOBILE_NO TEXT, COACH_NO TEXT, SEAT_NO INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Train1);
        db.execSQL("DROP TABLE IF EXISTS "+Train2);
        db.execSQL("DROP TABLE IF EXISTS "+Train3);
        db.execSQL("DROP TABLE IF EXISTS "+Train4);
        db.execSQL("DROP TABLE IF EXISTS "+Train5);
        db.execSQL("DROP TABLE IF EXISTS "+Train6);
        onCreate(db);
    }

    public boolean insertData(String train_no,String name,String age, String sex, String mob_no, String coach /*,int seatNo*/) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,sex);
        contentValues.put(COL_4,mob_no);
        contentValues.put(COL_5,coach);
        //contentValues.put(COL_6,seatNo);
        long result = db.insert(train_no,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public void insertExtraData(String train_no,String name,String age, String sex, String mob_no, String coach,int seatNo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_6,seatNo);
    }

    public Cursor getAllData(String train_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+train_no,null);
        return res;
    }

    public boolean updateData(String train_no,String id,String name,String age, String sex, String mob_no, String coach, int seatNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,sex);
        contentValues.put(COL_4,mob_no);
        contentValues.put(COL_5,coach);
        contentValues.put(COL_6,seatNo);
        db.update(train_no, contentValues, "PERSON_ID= ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id, String train_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(train_no, "PERSON_ID = ?",new String[] {id});
    }
}

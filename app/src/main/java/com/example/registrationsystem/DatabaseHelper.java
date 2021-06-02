package com.example.registrationsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.registrationsystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RegistrationSystem.db";
    public static final String TABLE_NAME = "Registration_Table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "FACULTY";
    public static final String COL_5 = "COURSE";
    public static final String COL_6 = "MODULES";
    public static final String COL_7 = "CLASS_GROUP";

    public static final String TABLE2_NAME = "User_Table";
    public static final String USER_COL1 = "ID";
    public static final String USER_COL2 = "NAME";
    public static final String USER_COL3 = "PASSWORD";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,FACULTY TEXT,COURSE,MODULES TEXT,CLASS_GROUP TEXT)");
        db.execSQL("create table " + TABLE2_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE2_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String surname, String faculty,String course,  String modules, String classGroup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, faculty);
        contentValues.put(COL_5, course);
        contentValues.put(COL_6, modules);
        contentValues.put(COL_7, classGroup);
        long result = db.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" order by CLASS_GROUP",null);
        return res;
    }

    public boolean updateData(String id, String name, String surname, String faculty,String course, String modules, String classGroup){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, faculty);
        contentValues.put(COL_5, course);
        contentValues.put(COL_6, modules);
        contentValues.put(COL_7, classGroup);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?", new String[]{id});
    }
    public List<Student> getListData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" order by CLASS_GROUP",null);
        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String faculty = res.getString(3);
            String course = res.getString(4);
            String modules = res.getString(5);
            String classGroup = res.getString(6);
            Student student = new Student(id,name,surname,faculty,course,modules,classGroup);
            arrayList.add(student);
        }
        return arrayList;

    }

    public List<Student> getListAppdevData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where CLASS_GROUP = 'Appdev'",null);
        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String faculty = res.getString(3);
            String course = res.getString(4);
            String modules = res.getString(5);
            String classGroup = res.getString(6);
            Student student = new Student(id,name,surname,faculty,course,modules,classGroup);
            arrayList.add(student);
        }
        return arrayList;

    }

    public List<Student> getListNetworksData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where CLASS_GROUP = 'Networks'",null);
        while(res.moveToNext()){
            String id = res.getString(0);
            String name = res.getString(1);
            String surname = res.getString(2);
            String faculty = res.getString(3);
            String course = res.getString(4);
            String modules = res.getString(5);
            String classGroup = res.getString(6);
            Student student = new Student(id,name,surname,faculty,course,modules,classGroup);
            arrayList.add(student);
        }
        return arrayList;



    }

}

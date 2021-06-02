package com.example.registrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.registrationsystem.model.Student;

import java.util.ArrayList;

public class ShowStudents extends AppCompatActivity {
    DatabaseHelper myDb;
    Button showBack;
    Button appdev;
    Button networks;
    Button all;
    ListView lv;
    public static Student student;
    AsandaAdapter adapter;
    public static ArrayList<Student> learner = new ArrayList<>();
    public static Integer [] pics = {R.drawable.net,R.drawable.appd};
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);
       networks = (Button)findViewById(R.id.networksShowBtn);
        appdev = (Button)findViewById(R.id.showFullClass);
        all = (Button)findViewById(R.id.networksShowBtn);
        showBack = (Button)findViewById(R.id.showBackButton);
        lv = (ListView)findViewById(R.id.lister);
        myDb = new DatabaseHelper(this);


    }
    public void showBack(View v){
        Intent showToMenu = new Intent(ShowStudents.this,MainActivity.class);
        startActivity(showToMenu);
    }
    public void loadListView(View v){
        Intent intent = new Intent(ShowStudents.this, ListViewShower.class);
        text = "full";
        intent.putExtra("Value",text);
        startActivityForResult(intent,1);
    }
    public void loadListAppdevView(View v){
        Intent intentAppdev = new Intent(ShowStudents.this, ListViewShower.class);
        text = "appdev";
        intentAppdev.putExtra("Value",text);
        startActivityForResult(intentAppdev,1);
    }
    public void loadListNetworksView(View v) {
        Intent intentNetworks = new Intent(ShowStudents.this, ListViewShower.class);
        text = "networks";
        intentNetworks.putExtra("Value", text);
        startActivityForResult(intentNetworks, 1);

    }
    /**
 public void showAll(View v){
 Cursor res=myDb.getAllData();

 if(res.getCount()==0){
 showMessage("Error","Nothing found");
 return;
 }
 int count = 0;
 while(res.moveToNext() && count<learner.length){
 String id = res.getString(0);
 String name = res.getString(1);
 String surname = res.getString(2);
 String faculty = res.getString(3);
     String course = res.getString(4);
     String modules = res.getString(5);
     String classGroup = res.getString(6);
 student = new Student(id,name,surname,faculty,course,modules,classGroup);
 learners[0] = student;

 }

 StringBuffer buffer= new StringBuffer();
 while(res.moveToNext()) {
 buffer.append("ID:"+res.getString(0)+"\n");
 buffer.append("NAME:"+res.getString(1)+"\n");
 buffer.append("SURNAME:"+res.getString(2)+"\n");
 buffer.append("FACULTY:"+res.getString(3)+"\n");
     buffer.append("COURSE:"+res.getString(4)+"\n");
     buffer.append("MODULES:"+res.getString(5)+"\n\n");
 buffer.append("CLASS_GROUP:"+res.getString(6)+"\n");

 }
 showMessage("Data",buffer.toString());


 }
 **/

/**public void showAppdev(View v){
 Cursor res=myDb.getAllAppdev();
 if(res.getCount()==0){
 showMessage("Error","Nothing found");
 return;
 }

 StringBuffer buffer= new StringBuffer();
 while(res.moveToNext()) {
 buffer.append("ID:"+res.getString(0)+"\n");
 buffer.append("NAME:"+res.getString(1)+"\n");
 buffer.append("SURNAME:"+res.getString(2)+"\n");
 buffer.append("FACULTY:"+res.getString(3)+"\n");
 buffer.append("COURSE:"+res.getString(4)+"\n");
 buffer.append("MODULES:"+res.getString(5)+"\n");
 buffer.append("CLASS_GROUP:"+res.getString(6)+"\n");

 }
 showMessage("Data",buffer.toString());


 }
 **/
/** public void showNetworks(View v){
 Cursor res=myDb.getAllNetworks();
 if(res.getCount()==0){
 showMessage("Error","Nothing found");
 return;
 }

 StringBuffer buffer= new StringBuffer();
 while(res.moveToNext()) {
 buffer.append("ID:"+res.getString(0)+"\n");
 buffer.append("NAME:"+res.getString(1)+"\n");
 buffer.append("SURNAME:"+res.getString(2)+"\n");
 buffer.append("FACULTY:"+res.getString(3)+"\n");
 buffer.append("COURSE:"+res.getString(4)+"\n");
 buffer.append("MODULES:"+res.getString(5)+"\n\n");
 buffer.append("CLASS_GROUP:"+res.getString(6)+"\n");

 }
 showMessage("Data",buffer.toString());


 }

 public void showMessage(String title,String Message){
 AlertDialog.Builder builder= new AlertDialog.Builder(this);
 builder.setCancelable(true);
 builder.setTitle(title);
 builder.setMessage(Message);
 builder.show();


 }
 **/

/**   Cursor res=myDb.getAllData();

 if(res.getCount()==0){
 showMessage("Error","Nothing found");
 return;
 }

 while(res.moveToNext()){
 String id = res.getString(0);
 String name = res.getString(1);
 String surname = res.getString(2);
 String faculty = res.getString(3);
 String course = res.getString(4);
 String modules = res.getString(5);
 String classGroup = res.getString(6);
 student = new Student(id,name,surname,faculty,course,classGroup,modules);
 learner.add(student);
 }

 learner = (ArrayList<Student>) myDb.getListData();
 adapter = new AsandaAdapter(this,learner);

 lv.setAdapter(adapter);

 }**/

}
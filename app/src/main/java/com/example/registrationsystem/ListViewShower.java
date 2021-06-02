package com.example.registrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.registrationsystem.model.Student;

import java.util.ArrayList;

public class ListViewShower extends AppCompatActivity {

    DatabaseHelper myDb;
    ListView lv;
    AsandaAdapter adapter;
    String text;
    public static ArrayList<Student> learner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_shower);
        lv = (ListView)findViewById(R.id.lister);
        myDb = new DatabaseHelper(this);
        text=getIntent().getExtras().getString("Value");
        if(text.equalsIgnoreCase(" full")) {
           learner = (ArrayList<Student>) myDb.getListData();
        }
        else if(text.equalsIgnoreCase(" appdev")){
           learner = (ArrayList<Student>) myDb.getListAppdevData();
        }
        else if(text.equalsIgnoreCase("networks")){
           learner = (ArrayList<Student>) myDb.getListNetworksData();
        }
        adapter = new AsandaAdapter(this,learner);

        lv.setAdapter(adapter);
    }
}

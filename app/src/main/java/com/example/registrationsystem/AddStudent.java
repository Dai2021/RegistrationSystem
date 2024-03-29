package com.example.registrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText addName;
    EditText addSurname;
    EditText addFaculty ;
    EditText addCourse;
    EditText addModules;
    EditText addClassGroup;
    Button addBack;
    Button addCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        myDb = new DatabaseHelper(this);
        addName = (EditText)findViewById(R.id.nameField2);
        addSurname = (EditText)findViewById(R.id.surnameField);
        addFaculty = (EditText)findViewById(R.id.facultyField2);
        addCourse = (EditText)findViewById(R.id.courseField);
        addModules = (EditText)findViewById(R.id.modulesField);
        addClassGroup = (EditText)findViewById(R.id.classGroupField);
        addBack = (Button)findViewById(R.id.addBack);
        addCreate = (Button)findViewById(R.id.create);

    }

    public void toMenu(View v){
        Intent addToMenu = new Intent(AddStudent.this,MainActivity.class);
        startActivity(addToMenu);
    }

    public void addStudent(View v){
        if(checkDataEntered()==true) {


            boolean Isinserted = myDb.insertData(addName.getText().toString(),
                    addSurname.getText().toString(),
                    addFaculty.getText().toString(),
                    addCourse.getText().toString(),
                    addModules.getText().toString(),
                    addClassGroup.getText().toString());
            if (Isinserted == true) {
                Toast.makeText(AddStudent.this, "Data inserted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(AddStudent.this, "Data not inserted", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(AddStudent.this, "Fill in the required fields", Toast.LENGTH_SHORT).show();
        }
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    public boolean checkDataEntered() {

        if (isEmpty(addName)) {
            addName.setError("Name is required!");
            return false;
        }

        else if (isEmpty(addSurname)) {
            addSurname.setError("Last name is required!");
            return false;
        }

            else if (isEmpty( addFaculty)) {
            addFaculty.setError("Faculty is required!");
            return false;

            }
                else if (isEmpty(addModules)) {
                addModules.setError("Modules is required!");
                return false;
                     }
                        else if (isEmpty(addClassGroup)) {
                        addClassGroup.setError("Class Name is required!");
                        return false;
                        }
                        else{
            return true;
        }


    }
}

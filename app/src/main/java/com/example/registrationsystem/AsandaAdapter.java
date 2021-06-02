package com.example.registrationsystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.registrationsystem.model.Student;

import java.util.ArrayList;

public class AsandaAdapter extends ArrayAdapter<Student> {

    private ArrayList<Student>learners;
    private Student student;
    private Activity context;

    public AsandaAdapter(Activity context,ArrayList <Student> learners) {
        super(context, R.layout.activity_main,learners);

        this.context = context;
        this.learners = learners;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layout,null,true);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView t1 = (TextView) rowView.findViewById(R.id.idView);
        TextView t2 = (TextView) rowView.findViewById(R.id.nameView);
        TextView t3 = (TextView) rowView.findViewById(R.id.surnameView);
        TextView t4 = (TextView) rowView.findViewById(R.id.facultyView);
        TextView t5 = (TextView) rowView.findViewById(R.id.courseView);
        TextView t6 = (TextView) rowView.findViewById(R.id.modulesView);
        TextView t7 = (TextView) rowView.findViewById(R.id.classView);
 /*
        Student student = new Student(learners[position].getId(),learners[position].getName(),learners[position].getSurname()learners[position].getFaculty(),learners[position].getCourse(),
               learners[position].getModules(),learners[position].getClassGroup());
       for(Student st:learners){
            student = new Student(st.getStudentNo(),st.getName(),st.getSurname(),st.getFaculty(),st.getCourse(),st.getModules(),st.getClassGroup());

         */
       /*student = new Student(learners.get(0).getId(),learners.get(0).getName(),learners.get(0).getId(),learners.get(0).getId(),learners.get(0).getId(),
                learners.get(0).getId(),learners.get(0).getId());*/
        t1.setText(learners.get(position).getId());
        t2.setText(learners.get(position).getName());
        t3.setText(learners.get(position).getSurname());
        t4.setText(learners.get(position).getFaculty());
        t5.setText(learners.get(position).getCourse());
        t6.setText(learners.get(position).getModules());
        t7.setText(learners.get(position).getClassGroup());

        if(learners.get(position).getClassGroup().equalsIgnoreCase("networks")) {
            imageView.setImageResource(R.drawable.net);
        }
        else{
            imageView.setImageResource(R.drawable.appd);
        }


        return rowView;




    }
}


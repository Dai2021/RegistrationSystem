package com.example.registrationsystem.model;

public class Student {
    String id;
    String name;
    String surname;
    String faculty;
    String course;
    String modules;
    String classGroup;

    public Student(String id, String name, String surname, String faculty, String course,  String modules, String classGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.course = course;
        this.modules = modules;
        this.classGroup = classGroup;
    }

    public Student(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = classGroup;
    }

    public String getClassGroup() { return classGroup; }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }


}

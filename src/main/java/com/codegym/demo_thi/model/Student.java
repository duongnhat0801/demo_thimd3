package com.codegym.demo_thi.model;

public class Student {
    private int id;
    private String code;
    private String name;
    private String class_room ;

    public Student() {
    }

    public Student(String code, String name, String class_room) {
        this.code = code;
        this.name = name;
        this.class_room = class_room;
    }

    public Student(int id, String code, String name, String class_room) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.class_room = class_room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }
}

package com.itheima.edu.info.manager.domain;

public class Student {
    private String name;
    private String age;
    private String birthday;

    public Student(String name, String age, String birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

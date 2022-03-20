package com.itheima.edu.info.manager.domain;

public class Student {
    private String name;
    private String age;
    private String birthday;

    /*
    * 静态随着类的加载而加载，优先于对象存在
    * 非静态需要在创建对象后，才可以使用
    * 静态方法中，只能访问静态成员（静态方法，静态变量等）
    * 非静态方法中，既可以访问静态成员，也可以访问非静态成员
    * 静态方法中，没有this关键字
    * */

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

package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private static Teacher[] teachers=new Teacher[5];
    public boolean addTeacher(Teacher teacher) {
        boolean addtrue=true;
        if(teachers==null){
            addtrue=false;
        }else{
            for (int i = 0; i < teachers.length; i++) {
                Teacher teacher1=teachers[i];
                if(teacher1==null){
                    teachers[i]=teacher;
                    break;
                }
            }
        }
        return addtrue;

    }

    public Teacher[] getTeachers() {
        return teachers;
    }
}

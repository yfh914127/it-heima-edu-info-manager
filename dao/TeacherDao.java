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

    public void deleteTeacherById(String id) {
        //查询这个id在数组中的索引位置
        int index=getIndex(id);
        //将该索引位置的元素使用null进行替换
        teachers[index]=null;
    }

    public int getIndex(String id){
        int index=-1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher=teachers[i];
            if(teacher!=null && teacher.getId().equals(id)){
                index=i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(Teacher teacher) {
        int index=getIndex(teacher.getId());
        teachers[index]=teacher;

    }
}

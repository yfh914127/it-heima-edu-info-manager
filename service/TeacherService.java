package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {

    private TeacherDao teacherDao=new TeacherDao();

    public boolean isExists(String id) {
        //获取到学生数组
        Teacher[] teachers=teacherDao.getTeachers();
        boolean exist=false;
        //遍历数组
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher=teachers[i];
            if(teacher!=null && teacher.getId().equals(id)){
                exist=true;
            }
        }
        return exist;
    }

    public boolean addTeacher(Teacher teacher) {
        boolean addtrue=teacherDao.addTeacher(teacher);
        return addtrue;
    }

    public Teacher[] getTeachers() {
        boolean flag;
        Teacher[] teachers=teacherDao.getTeachers();
        if(teachers!=null){
            flag=true;
        }else{
            flag=false;
        }
        if(flag){
            return teachers;
        }else{
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }
}

package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    public boolean addStudent(Student student) {
        //1.创建StudentDao
        StudentDao studentDao=new StudentDao();
        //2.将学生对象，传递给StudentDao库管中的addtudent方法
        //3.将返回的boolean类型结果，返回给StudentController
        return studentDao.addStudent(student);
    }
}

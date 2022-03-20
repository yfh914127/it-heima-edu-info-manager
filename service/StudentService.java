package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    StudentDao studentDao = new StudentDao();
    public boolean addStudent(Student student) {
        //1.创建StudentDao

        //2.将学生对象，传递给StudentDao库管中的addtudent方法
        //3.将返回的boolean类型结果，返回给StudentController
        return studentDao.addStudent(student);
    }

    public boolean isExists(String name) {
        //1. 从StudentDao中获取存储学生对象的数组
        //调用内部findAllStudent方法
        //该方法返回学生数组
        //遍历该学生数组，判断学号是否存在
        //返回true或者false结果
        Student[] students = studentDao.findAllStudent();
        //假设最开始的结果是不存在这个学生
        boolean result=false;
        for (int i = 0; i < students.length; i++) {
            Student student=students[i];
            if(student!=null && student.getName().equals(name)){
                result=true;
                break;
            }
        }
        return result;
    }

    public Student[] findAllStudent() {
        //1.调用库管对象中的findAllStudent获取学生对象数组
        Student[] students=studentDao.findAllStudent();
        //2.判断数组中是否有学生信息（有：返回地址，没有：返回null）
        boolean flag=false;
        for (int i = 0; i < students.length; i++) {
            Student student=students[i];
            if(student!=null){
                flag=true;
                break;
            }
        }
        if(flag==false){
            return null;
        }else{
            return students;
        }
    }

    public void deleteStduentByName(String name) {
        studentDao.deleteSTudentByName(name);
    }
}

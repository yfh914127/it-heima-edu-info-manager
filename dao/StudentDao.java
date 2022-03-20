package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] students=new Student[5];
    public boolean addStudent(Student student) {
        //1.创建学生对象数组
        //2.添加学生到数组
        //2.1 定义变量index为-1，假设数组已经存满，没有null元素
        int index=-1;
        //2.2 遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i < students.length; i++) {
            Student student1=students[i];
            if(student1==null){
                index=i;
                break;
            }
        }
        //2.3 如果是null。，让index变量记录当前的索引位置，并使用break来结束循环
        //3 返回是否添加成功的boolean类型状态
        if(index==-1){
            return false;
        }else{
            students[index]=student;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return students;
    }
}

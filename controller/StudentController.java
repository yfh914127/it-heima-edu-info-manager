package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    public void start() {

        Scanner sc=new Scanner(System.in);

        lo:while(true){
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice=sc.next();
            switch(choice){
                case "1":
                    /*System.out.println("添加学生");*/
                    addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    break;
                case "3":
                    System.out.println("修改学生");
                    break;
                case "4":
                    System.out.println("查看学生");
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统，再见!");
                    break lo;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    public void addStudent() {
        //1.键盘接收学生信息
        StudentService studentService=new StudentService();
        Scanner sc=new Scanner(System.in);
        String name=null;
        while(true){
            System.out.println("请输入学生姓名");
            name=sc.next();
            boolean flag=studentService.isExists(name);
            if(flag==false){
                break;
            }else{
                System.out.println("学号已经被占用，请重新输入");
            }
        }
        System.out.println("请输入学生年龄");
        String age=sc.next();
        System.out.println("请输入学生生日");
        String birthday=sc.next();
        //2。将学生信息封装成学生对象
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        student.setBirthday(birthday);
        //3。将学生对象，传递给StudentService中的方法addStudent();
        boolean result=studentService.addStudent(student);
        //4.根据返回的boolean类型返回值，在控制台打印输出成功/失败
        if(result==true){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}

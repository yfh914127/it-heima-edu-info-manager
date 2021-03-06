package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private Scanner sc = new Scanner(System.in);
    private StudentService studentService = new StudentService();

    public void start() {


        lo:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    /*System.out.println("添加学生");*/
                    addStudent();
                    break;
                case "2":
                    /*System.out.println("删除学生");*/
                    deleteStudentByName();
                    break;
                case "3":
                    /*System.out.println("修改学生");*/
                    updateStudent();
                    break;
                case "4":
                    /*System.out.println("查看学生");*/
                    findAllStudent();

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

    private void updateStudent() {
        String name=improtStudent();
        System.out.println("请输入学生年龄");
        String age = sc.next();
        System.out.println("请输入学生生日");
        String birthday = sc.next();
        Student student = new Student(name, age, birthday);
        //3 调用业务员中的deleteStudentByName方法，根据name，一直修改
        studentService.updateStudent(name, student);
        //4 提示修改成功
        System.out.println("修改成功");

    }

    private String improtStudent() {
        String name;
        while (true) {
            //1 键盘录入需要删除的学生姓名
            System.out.println("请输入学生姓名");
            name = sc.next();
            //2 判断学生姓名是否存在，如果不存在，则需要一直录入
            boolean exists = studentService.isExists(name);
            if (!exists) {
                System.out.println("您输入的学生不存在，请重新输入");
            } else {
                return name;
            }

        }
    }

    public void findAllStudent() {
        //1.调用业务员中的获取方法，得到学生的对象数组
        Student[] stu = studentService.findAllStudent();
        //2.判断数组的内存地址，是否为null
        if (stu == null) {
            System.out.println("查无信息，请稍后再试");
            return;
        }
        //3.遍历数组，获取学生信息并打印在控制台上
        System.out.println("姓名\t年龄\t\t生日");
        for (int i = 0; i < stu.length; i++) {
            Student student = stu[i];
            if (student != null) {
                System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getBirthday() + "\t\t");
            }
        }

    }

    public void addStudent() {
        //1.键盘接收学生信息
        studentService = new StudentService();
        Scanner sc = new Scanner(System.in);
        String name = null;
        while (true) {
            System.out.println("请输入学生姓名");
            name = sc.next();
            boolean flag = studentService.isExists(name);
            if (flag == false) {
                break;
            } else {
                System.out.println("姓名已经被占用，请重新输入");
            }
        }
        System.out.println("请输入学生年龄");
        String age = sc.next();
        System.out.println("请输入学生生日");
        String birthday = sc.next();
        //2。将学生信息封装成学生对象
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setBirthday(birthday);
        //3。将学生对象，传递给StudentService中的方法addStudent();
        boolean result = studentService.addStudent(student);
        //4.根据返回的boolean类型返回值，在控制台打印输出成功/失败
        if (result == true) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public void deleteStudentByName() {
        String name=improtStudent();
        //3 调用业务员中的deleteStudentByName方法，根据name，一直删除
        studentService.deleteStduentByName(name);
        //4 提示删除成功
        System.out.println("删除成功");

    }
}

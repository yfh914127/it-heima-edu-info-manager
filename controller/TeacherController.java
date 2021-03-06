package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService=new TeacherService();
    private String id;

    public void start() {
        teacherloop:
        while (true) {
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            //从控制台输入选择
            String choice = sc.next();
            switch (choice) {
                case "1":
                    /*System.out.println("添加老师");*/
                    addTeacher();
                    break;
                case "2":
                    /*System.out.println("删除老师");*/
                    deleteTeacherById();
                    break;
                case "3":
                    /*System.out.println("修改老师");*/
                    updateTeacher();
                    break;
                case "4":
                    /*System.out.println("查看老师");*/
                     getTeachers();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统，再见!");
                    break teacherloop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }

    }

    public void updateTeacher() {
        String id;
        while(true){
            //键盘接收要删除的老师id
            System.out.println("请输入你要修改的老师ID");
            id=sc.next();
            //交给业务员判断是否存在这个id
            boolean exists=teacherService.isExists(id);
            if(!exists){
                System.out.println("您输入的id不存在，请重新输入");
            }else{
                break;
            }
        }
        //键盘录入新的老师信息
        //请输入老师姓名
        System.out.println("请输入你要修改的老师姓名");
        String name=sc.next();
        System.out.println("请输入你要修改的老师年龄");
        String age=sc.next();
        System.out.println("请输入你要修改的老师生日");
        String birthday=sc.next();
        //封装为新的老师对象
        Teacher teacher=new Teacher(id,name,age,birthday);
        //调用业务员的修改方法
        teacherService.updateTeacher(teacher);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {
        String id;
        while(true){
            //键盘接收要删除的老师id
            System.out.println("请输入你要删除的老师ID");
            id=sc.next();
            //交给业务员判断是否存在这个id
            boolean exists=teacherService.isExists(id);
            if(!exists){
                System.out.println("您输入的id不存在，请重新输入");
            }else{
                break;
            }
        }
         //2 调用业务员中的删除方法，根据id删除老师
        teacherService.deleteTeacherById(id);

        //3 提示删除成功
        System.out.println("删除成功");


    }

    public void getTeachers() {
        Teacher[] teachers=teacherService.getTeachers();
        if(teachers==null){
            System.out.println("暂时没有添加老师");
        }else{
            System.out.println("学号\t\t姓名\t年龄\t生日");
            for (int i = 0; i < teachers.length; i++) {
                Teacher teacher=teachers[i];
                if(teacher!=null){
                    System.out.println(teacher.getId()+"\t"+teacher.getName()+"\t"+teacher.getAge()+"\t"+teacher.getBirthday());
                }

            }
        }
    }

    private void addTeacher() {
        //输入要添加老师的信息
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入要查询的老师的id");
            id=sc.next();
            boolean exist=teacherService.isExists(id);
            if(exist) {
                System.out.println("请重新输入id");
            }else{
                break;
            }
        }
        System.out.println("请输入要查询的老师的姓名");
        String name=sc.next();
        System.out.println("请输入要查询的老师的年龄");
        String age=sc.next();
        System.out.println("请输入要查询的老师的生日");
        String birthday=sc.next();
        Teacher teacher=new Teacher(id,name,age,birthday);
        boolean addtrue=teacherService.addTeacher(teacher);
        if(addtrue){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
}

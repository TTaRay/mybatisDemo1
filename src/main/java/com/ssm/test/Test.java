package com.ssm.test;

import com.ssm.beans.Student;
import com.ssm.service.impl.StudentServiceImpl;

public class Test {
    public static void main(String[] args) {
        /*Student stu=new Student();
        stu.setName("格格");
        stu.setAge(12);
        stu.setScore(88);
        new StudentServiceImpl().insertStudent(stu);*/

        /*Student student = new StudentServiceImpl().getStudentById(2);
        System.out.println(student.getName()+"--"+student.getAge()+"--"+student.getScore());*/

//        new StudentServiceImpl().delStudentById(36);

        Student stu=new Student(41,"咯咯",19,99);
        new StudentServiceImpl().updStudent(stu);
    }
}

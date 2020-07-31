package com.ssm.dao;

import com.ssm.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    void insertStudent(Student student);
    Student getStudentById(int id);
    void delStudentById(int id);
    void updStudent(Student student);
}

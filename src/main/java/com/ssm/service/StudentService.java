package com.ssm.service;

import com.ssm.beans.Student;

public interface StudentService {
    void insertStudent(Student student);
    Student getStudentById(int id);
    void delStudentById(int id);
    void updStudent(Student student);
}

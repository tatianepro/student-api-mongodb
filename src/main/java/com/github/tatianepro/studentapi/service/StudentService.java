package com.github.tatianepro.studentapi.service;

import com.github.tatianepro.studentapi.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    String updateStudent(String id, Student student);
    void deleteStudent(String id);
}

package com.github.tatianepro.studentapi.service.impl;

import com.github.tatianepro.studentapi.entity.Student;
import com.github.tatianepro.studentapi.repository.StudentRepository;
import com.github.tatianepro.studentapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student createStudent(Student student) {
        return repository.insert(student);
    }

    public Student findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("id not found"));
    }

    public String updateStudent(String id, Student student) {
        Student studentFound = findById(id);
        studentFound.setId(id);
        studentFound.setFirstName(student.getFirstName());
        studentFound.setLastName(student.getLastName());
        repository.save(studentFound);
        return id;
    }

    public void deleteStudent(String id) {
        Student studentFound = findById(id);
        repository.delete(studentFound);
    }
}

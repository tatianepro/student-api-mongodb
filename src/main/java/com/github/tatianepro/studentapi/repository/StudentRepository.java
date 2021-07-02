package com.github.tatianepro.studentapi.repository;

import com.github.tatianepro.studentapi.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}

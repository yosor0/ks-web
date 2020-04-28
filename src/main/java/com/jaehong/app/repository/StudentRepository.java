package com.jaehong.app.repository;

import com.jaehong.app.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}

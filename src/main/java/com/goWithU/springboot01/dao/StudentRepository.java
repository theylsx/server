package com.goWithU.springboot01.dao;

import com.goWithU.springboot01.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}

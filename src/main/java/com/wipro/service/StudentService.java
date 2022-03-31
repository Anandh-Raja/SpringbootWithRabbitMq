package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.entities.Student;

@Service
public interface StudentService {
public Student createStudent(Student stud);
public Student updateStudent(Student stud, int id);
public Optional<Student> getStudentById(int id);
public List<Student> getByGpa();
public Boolean deleteStudent(int id);
}

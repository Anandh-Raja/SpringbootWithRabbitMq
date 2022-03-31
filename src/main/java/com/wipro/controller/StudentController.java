package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entities.Student;
import com.wipro.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("/newStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student s=service.createStudent(student);
		return ResponseEntity.ok(s);
	}
	@PutMapping("/editstudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id){
		Student s=service.updateStudent(student, id);
		return ResponseEntity.ok(s);
	}
	@GetMapping("/getstudent")
	public ResponseEntity<Student> getStudent(@RequestBody Student student,@PathVariable int id){
		Optional<Student> studlist=service.getStudentById(id);
		if(studlist.isEmpty()) 
		return ResponseEntity.noContent().build();return ResponseEntity.ok(studlist.get());
	}
	@GetMapping("/gpa3.5")
	public ResponseEntity<List<Student>> getStudentGpa(){
		List<Student> studlist=service.getByGpa();
		if(studlist.isEmpty())
		return ResponseEntity.noContent().build();return ResponseEntity.ok(studlist);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable int id){
		Boolean result=service.deleteStudent(id);
		if(result) {
		return ResponseEntity.accepted().body("Student Removed");
		}
		return ResponseEntity.noContent().build();
	}
	

}

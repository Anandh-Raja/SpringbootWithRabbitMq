package com.wipro.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entities.Student;
import com.wipro.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studRepo;

	@Override
	public Student createStudent(Student stud) {
		
		return studRepo.save(stud);
	}

	@Override
	public Student updateStudent(Student stud, int id) {
		// TODO Auto-generated method stub
		Optional<Student> stu=studRepo.findById(id);
		if(stu.isPresent()) {
		List<Student> student=studRepo.findAll();
		student.stream().filter(s->s.getId()==stud.getId()).forEach(s -> {s.setName(stud.getName());s.setGrade(stud.getGrade());s.setGpa(stud.getGpa());s.setGender(stud.getGender());s.setActivities(stud.getActivities());});
		Student updateStudent=studRepo.save(student.get(id));
		return updateStudent;
		}else {
			studRepo.save(stud);
		}
		return stud;
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		
		return studRepo.findById(id);
	}

	@Override
	public List<Student> getByGpa() {
		List<Student> studlist=studRepo.findAll();
		
		return studlist.stream().filter(e->e.getGpa()>3.5).collect(Collectors.toList());
	}

	@Override
	public Boolean deleteStudent(int id) {
		Optional<Student> stud=studRepo.findById(id);
		if(stud.isPresent()) {
			studRepo.deleteById(id);
			return true;
		}else {
		return false;
	}
	}

}

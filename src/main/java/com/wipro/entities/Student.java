package com.wipro.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private int grade;
private double gpa;
private String gender;
@ElementCollection(targetClass=String.class)
private List<String> activities;
public Student() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public double getGpa() {
	return gpa;
}
public void setGpa(double gpa) {
	this.gpa = gpa;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public List<String> getActivities() {
	return activities;
}
public void setActivities(List<String> activities) {
	this.activities = activities;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", gpa=" + gpa + ", gender=" + gender
			+ ", activities=" + activities + "]";
}
public Student(int id, String name, int grade, double gpa, String gender, List<String> activities) {
	super();
	this.id = id;
	this.name = name;
	this.grade = grade;
	this.gpa = gpa;
	this.gender = gender;
	this.activities = activities;
}

}

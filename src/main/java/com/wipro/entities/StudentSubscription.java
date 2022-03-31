package com.wipro.entities;

import java.util.List;

public class StudentSubscription {
	private int id;
	private String name;
	private List<String> sports;
	
	public StudentSubscription() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<String> getSports() {
		return sports;
	}
	public void setSports(List<String> sports) {
		this.sports = sports;
	}
	@Override
	public String toString() {
		return "StudentSubscription [id=" + id + ", name=" + name + ", sports=" + sports + "]";
	}
	public StudentSubscription(int id, String name, List<String> sports) {
		super();
		this.id = id;
		this.name = name;
		this.sports = sports;
	}
	

}

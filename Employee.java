package com.jdbc.entity;

public class Employee {
	private String name,gender;
	private int id ,salary;
	
	public Employee() {
		super();
	}
	public Employee(String name, String gender, int id, int salary) {
		super();
		this.name = name;
		this.gender = gender;
		this.id = id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", id=" + id + ", salary=" + salary + "]";
	}
	
	
	
}

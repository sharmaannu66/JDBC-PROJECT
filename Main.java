package com.jdbc.client;

import java.util.List;

import com.jdbc.dao.EmployeeDao;
import com.jdbc.dao.EmployeeDaoImpl;
import com.jdbc.entity.Employee;

public class Main {

	public static void main(String[] args) {

		Employee emp = new Employee("Anurag singh", "male", 10, 98754);
		EmployeeDao dao = new EmployeeDaoImpl();
//		dao.insertEmp(emp);
//		
//		emp = new Employee("Gaurav singh", "male", 11, 45787);
//		dao.insertEmp(emp);

//		emp = new Employee("Dhairya singh", "male", 12, 45787);
//		dao.insertEmp(emp);
//
		emp = new Employee("Bharosha singh", "male", 14, 45787);
		dao.insertEmpByPs(emp);

//		dao.updateEmp(emp);
//		dao.deleteEmp(12);
		dao.getAllEmps();
//		List<Employee> allEmpRecords = dao.getAllEmpRecords();
//		
//		for(Employee em : allEmpRecords)
//		{
//			System.out.println("EMP:  "+em);
//		}
		
//		dao.getEmpByName("wwwww' or 1=1");
	}

}

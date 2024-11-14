package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdbc.entity.Employee;
import com.mysql.cj.jdbc.Driver;

public class EmployeeDaoImpl implements EmployeeDao {
	static Connection conn;
	static {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/riya", "root", "root");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/riya", prop);
			Driver d = new Driver();

			conn = d.connect("jdbc:mysql://localhost:3306/riya", prop);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertEmp(Employee e) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into employee(id,name,gender,salary) values(" + e.getId() + ",'" + e.getName()
					+ "','" + e.getGender() + "'," + e.getSalary() + ")");
			System.out.println("EmployeeDaoImpl.insertEmp()");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void insertEmpByPs(Employee e) {
		try (PreparedStatement ps = conn
				.prepareStatement("insert into employee(id,name,gender,salary) values(?,?,?,?)")) {
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getGender());
			ps.setInt(4, e.getSalary());
			ps.executeUpdate();
			System.out.println("Insert by PS");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void updateEmp(Employee e) {

		try (Statement statement = conn.createStatement()) {
			statement.executeUpdate("update employee set name = '" + e.getName() + "' , salary = " + e.getSalary()
					+ " where id =" + e.getId());
			System.out.println("Update successful..................");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void deleteEmp(int id) {
		try (Statement statement = conn.createStatement()) {
			statement.executeUpdate("delete from employee where id = " + id);
			System.out.println("Record deleted successful..................");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void getEmpById(int id) {
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery("select * from employee where id=" + id);

			while (rs.next()) {
				System.out.println("ID = " + rs.getInt(1) + "  Name = " + rs.getString(2) + " Gender = "
						+ rs.getString(3) + " Salary = " + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getEmpByName(String name) {
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery("select * from employee where name='" + name);

			while (rs.next()) {
				System.out.println("ID = " + rs.getInt(1) + "  Name = " + rs.getString(2) + " Gender = "
						+ rs.getString(3) + " Salary = " + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllEmps() {
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery("select * from employee");

			while (rs.next()) {
				System.out.println("ID = " + rs.getInt(1) + "  Name = " + rs.getString(2) + " Gender = "
						+ rs.getString(3) + " Salary = " + rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmpRecords() {
		List<Employee> al = new ArrayList<Employee>();
		Employee e;
		try (Statement statement = conn.createStatement()) {
			ResultSet rs = statement.executeQuery("select * from employee");

			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setSalary(rs.getInt(4));
				al.add(e);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return al;
	}

}

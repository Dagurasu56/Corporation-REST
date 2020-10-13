package io.github.dagurasu.corp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import io.github.dagurasu.corp.factory.ConnectionFactory;
import io.github.dagurasu.corp.model.Employee;

public class EmployeeDao extends ConnectionFactory {

	private static EmployeeDao instance;

	public static EmployeeDao getInstance() {
		if (instance == null)
			instance = new EmployeeDao();
		return instance;

	}

	public ArrayList<Employee> listAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Employee> employees = null;

		con = createConnection();
		employees = new ArrayList<Employee>();

		try {
			ps = con.prepareStatement("select * from employees order by name");
			rs = ps.executeQuery();

			while (rs.next()) {
				Employee employee = new Employee();

				employee.setId(rs.getLong("id"));
				employee.setFirstName(rs.getString("first name"));
				employee.setLastName(rs.getString("last name"));
				employee.setCompany(rs.getString("company"));
				employee.setRegistration(rs.getString("registration"));
				employee.setSalary(rs.getDouble("salary"));

				employees.add(employee);
			}

		} catch (Exception e) {
			System.out.println("Error listing all employees: " + e);
			e.printStackTrace();
		} finally {

			closeConnection(con, ps, rs);
		}
		return employees;
	}

}

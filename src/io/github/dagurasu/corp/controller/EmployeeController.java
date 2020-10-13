package io.github.dagurasu.corp.controller;

import java.util.ArrayList;

import io.github.dagurasu.corp.dao.EmployeeDao;
import io.github.dagurasu.corp.model.Employee;

public class EmployeeController {

	public ArrayList<Employee> listAll() {
		return EmployeeDao.getInstance().listAll();
	}

}

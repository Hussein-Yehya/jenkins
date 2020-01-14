package br.com.betalk.jenkins.service;

import java.util.List;

import br.com.betalk.jenkins.model.Employee;

public interface EmployeeService {

	public Employee getEmployeeByName(String name);
	
	public List<Employee> getAllEmployees();
	
}

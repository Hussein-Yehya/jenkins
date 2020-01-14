package br.com.betalk.jenkins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.betalk.jenkins.model.Employee;
import br.com.betalk.jenkins.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}
}
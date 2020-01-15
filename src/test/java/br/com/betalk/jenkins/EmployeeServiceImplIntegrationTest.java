package br.com.betalk.jenkins;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.betalk.jenkins.model.Employee;
import br.com.betalk.jenkins.repository.EmployeeRepository;
import br.com.betalk.jenkins.service.EmployeeService;
import br.com.betalk.jenkins.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "alex";

		Employee alex = new Employee("alex");

		Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);

		Employee found = employeeService.getEmployeeByName(name);

		assertEquals(found.getName(), name);
	}
}

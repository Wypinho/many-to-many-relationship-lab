package com.codeclan.example.employee_relationship_lab;

import com.codeclan.example.employee_relationship_lab.models.Department;
import com.codeclan.example.employee_relationship_lab.models.Employee;
import com.codeclan.example.employee_relationship_lab.models.Project;
import com.codeclan.example.employee_relationship_lab.repositories.DepartmentRepository;
import com.codeclan.example.employee_relationship_lab.repositories.EmployeeRepository;
import com.codeclan.example.employee_relationship_lab.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeRelationshipLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDept(){
		Department department = new Department("accounts");
		departmentRepository.save(department);
		Employee employee = new Employee("Steve", "Vance", 1, department);
		employeeRepository.save(employee);
	}

	@Test
	public void createEmployeeAndProject(){
		Department department = new Department("accounts");
		departmentRepository.save(department);
		Employee employee = new Employee("Steve", "Vance", 1, department);
		employeeRepository.save(employee);
		Project project = new Project("PassCodeClan", 80);
		projectRepository.save(project);
		project.addEmployee(employee);
		projectRepository.save(project);
	}


}

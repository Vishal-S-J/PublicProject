package com.example.springgradle.repository;

import com.example.springgradle.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class EmployeeRepositoryTest {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRepositoryTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Snow");
        employee.setEmail("john.snow.got@gmail.com");
        employee.setDepartment("IT");
        employee.setProject("Product");
        employee.setSalary(BigDecimal.valueOf(56323.55));

        Employee persistEmployee = employeeRepository.save(employee);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(persistEmployee.getEmployeeId(), "ID was not generated"),
                () -> Assertions.assertTrue(employeeRepository.findById(persistEmployee.getEmployeeId()).isPresent(), "Employee not found")
        );
    }

    @Test
    public void testDataLoaded() {
        Employee employeeToSearch = new Employee();
        employeeToSearch.setEmployeeId(1);

        Example<Employee> employeeExample = Example.of(employeeToSearch);

        Optional<Employee> optionalEmployee = employeeRepository.findOne(employeeExample);

        System.out.println(employeeToSearch.getFirstName());
        System.out.println(optionalEmployee.isPresent());
        Assertions.assertTrue(optionalEmployee.isPresent(), "Employee not found");
        Assertions.assertEquals(optionalEmployee.get().getDepartment(), "IT", "wrong department");
    }
}

package com.arrisdev.arrisdev.service;

import com.arrisdev.arrisdev.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getEmployeeByFirstname(String firstname);
    List<Employee> getEmployeeByEmailId(String emailId);
    Optional<Employee> findById(Long id);
    Employee UpdateEmployee(Employee employee, Long id);
    boolean deleteEmployee(Long id);
    List<Employee> getAllEmployees();
}

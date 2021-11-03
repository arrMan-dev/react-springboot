package com.arrisdev.arrisdev.service;

import com.arrisdev.arrisdev.exception.ResourceNotFoundException;
import com.arrisdev.arrisdev.model.Employee;
import com.arrisdev.arrisdev.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        logger.info("Saving employee in service: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeByFirstname(String firstname) {
        logger.info("Fetching employee by firstname in service: {}", firstname);
        try {
            return employeeRepository.findEmployeeByEmailId(firstname);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Employee with" + firstname + " could not be found.");
        }
    }

    @Override
    public List<Employee> getEmployeeByEmailId(String emailId) {
        logger.info("Fetching employee by email id in service: {}", emailId);
        try {
            return employeeRepository.findEmployeeByEmailId(emailId);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Employee with" + emailId + " could not be found.");
        }

    }

    @Override
    public Optional<Employee> findById(Long id) {
        logger.info("Fetching employee by Id in service: {}", id);
        try {
            return employeeRepository.findById(id);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Employee could not be found" + id);
        }

    }

    @Override
    public Employee UpdateEmployee(Employee employee, Long id) {
        logger.info("Updating employee in service: {}", employee, id);
        try {
            return employeeRepository.save(employee);
        } catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Employee could not be found" + employee + id);
        }

    }

    @Override
    public boolean deleteEmployee(Long id) {
        logger.info("Deleting employee in service: {}", id);
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees in service: {}");

        return employeeRepository.findAll();
    }
}

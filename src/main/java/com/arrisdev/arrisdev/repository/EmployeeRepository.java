package com.arrisdev.arrisdev.repository;

import com.arrisdev.arrisdev.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByFirstname(String firstname);
    List<Employee> findEmployeeByEmailId(String emailId);
    Optional<Employee> findById(Long id);
}

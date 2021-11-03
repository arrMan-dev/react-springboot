package com.arrisdev.arrisdev.controller;

import com.arrisdev.arrisdev.model.Employee;
import com.arrisdev.arrisdev.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@Slf4j
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        logger.info("Saving employee in controller: {}", employee);
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        logger.info("Updating employee in controller: {}", id);
        return new ResponseEntity<>(employeeService.UpdateEmployee(employee, id), HttpStatus.OK);
    }

    @GetMapping("/getemployee/{id}")
    public ResponseEntity<?> getById(@PathVariable ("id") Long id){
        logger.info("Fetching employee by id in controller: {}", id);
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{firstname}")
    public ResponseEntity<?> getEmployeeByFirstName(@PathVariable ("firstname") String firstname){
        logger.info("Fetching employee by firstname in controller: {}", firstname);
        return new ResponseEntity<>(employeeService.getEmployeeByFirstname(firstname), HttpStatus.ACCEPTED);

    }

    @GetMapping("/get/{emailId")
    public ResponseEntity<?> getEmployeeByEmailId(@PathVariable ("emailId") String emailId){
        logger.info("Fetching employee by emailId in controller: {}", emailId);
        return new ResponseEntity<>(employeeService.getEmployeeByEmailId(emailId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable ("id") Long id){
        employeeService.deleteEmployee(id);
        return true;
    }
}

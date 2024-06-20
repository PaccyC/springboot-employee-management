package rw.ac.app.employeeservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rw.ac.app.employeeservice.entities.Employee;
import rw.ac.app.employeeservice.service.EmployeeService;
import rw.ac.app.employeeservice.service.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return  employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById( @PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long id) {
        return employeeService.updateEmployee(id, employee);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

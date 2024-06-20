package rw.ac.app.employeeservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import rw.ac.app.employeeservice.entities.Employee;
import rw.ac.app.employeeservice.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private final EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(@PathVariable Long id,Employee employee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setInstitution(employee.getInstitution());
            existingEmployee.setPosition(employee.getPosition());
            return employeeRepository.save(existingEmployee);
        }).orElse(null);
    }


    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

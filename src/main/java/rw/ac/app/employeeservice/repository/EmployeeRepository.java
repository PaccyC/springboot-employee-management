package rw.ac.app.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.app.employeeservice.entities.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}

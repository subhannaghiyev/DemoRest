package az.spring.rest.springrestdemo.repository;

import az.spring.rest.springrestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    List<Employee> findByNameOrSurname(String name,String surname);

}

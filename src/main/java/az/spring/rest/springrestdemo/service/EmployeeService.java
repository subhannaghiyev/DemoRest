package az.spring.rest.springrestdemo.service;

import az.spring.rest.springrestdemo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto getById(Integer id);

    void createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getByNameOrSurname(String name, String surname);

    void update(EmployeeDto employeeDto, Integer id);

    void deleteEmployee(Integer id);

    Long count();
}

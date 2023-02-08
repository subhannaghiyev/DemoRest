package az.spring.rest.springrestdemo.controller;

import az.spring.rest.springrestdemo.dto.EmployeeDto;
import az.spring.rest.springrestdemo.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping()
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/search")
    public List<EmployeeDto> getByNameAndSurname(@RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
        name = name == null ? "asddasadsads" : name;
        return employeeService.getByNameOrSurname(name,surname);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) {
        employeeService.update(employeeDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("/count")
    public Long count(){
        return employeeService.count();
    }
}

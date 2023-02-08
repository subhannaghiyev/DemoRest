package az.spring.rest.springrestdemo.service.impl;

import az.spring.rest.springrestdemo.dto.EmployeeAddressesDto;
import az.spring.rest.springrestdemo.dto.EmployeeDto;
import az.spring.rest.springrestdemo.entity.Employee;
import az.spring.rest.springrestdemo.entity.EmployeeAddresses;
import az.spring.rest.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.springrestdemo.exception.CustomRestException;
import az.spring.rest.springrestdemo.repository.EmployeeRepository;
import az.spring.rest.springrestdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setSurname(employee.getSurname());
            employeeDto.setAge(employee.getAge());
            employeeDto.setSalary(employee.getSalary());
            employeeDtos.add(employeeDto);

            List<EmployeeAddresses> addresses = employee.getEmployeeAddresses();

            List<EmployeeAddressesDto> dtos = new ArrayList<>();

            for (EmployeeAddresses emp : addresses) {
                EmployeeAddressesDto dto = new EmployeeAddressesDto();
                dto.setId(emp.getId());
                dto.setLastAddress(emp.getLastAddress());
                dto.setCurrentAddress(emp.getCurrentAddress());


                dtos.add(dto);
            }
            employeeDto.setEmployeeAddresses(dtos);
        }

        return employeeDtos;
    }

    @Override
    public EmployeeDto getById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomRestException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND));
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setSalary(employee.getSalary());

        List<EmployeeAddresses> addresses = employee.getEmployeeAddresses();

        List<EmployeeAddressesDto> dtos = new ArrayList<>();

        for (EmployeeAddresses emp : addresses) {

            EmployeeAddressesDto dto = new EmployeeAddressesDto();
            dto.setId(emp.getId());
            dto.setLastAddress(emp.getLastAddress());
            dto.setCurrentAddress(emp.getCurrentAddress());

            dtos.add(dto);
        }

        employeeDto.setEmployeeAddresses(dtos);

        return employeeDto;
    }

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
//      BeanUtils.copyProperties(employeeDto, employee);
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());

        List<EmployeeAddressesDto> addresses = employeeDto.getEmployeeAddresses();

        List<EmployeeAddresses> addresses1 = new ArrayList<>();

        for (EmployeeAddressesDto dto : addresses) {
            EmployeeAddresses emp = new EmployeeAddresses();
            emp.setId(dto.getId());
            emp.setLastAddress(dto.getLastAddress());
            emp.setCurrentAddress(dto.getCurrentAddress());
            emp.setEmployeeId(employee);

            addresses1.add(emp);
        }
        employee.setEmployeeAddresses(addresses1);

        employeeRepository.save(employee);

    }

    @Override
    public List<EmployeeDto> getByNameOrSurname(String name, String surname) {
        List<Employee> byNameOrSurname = employeeRepository.findByNameOrSurname(name, surname);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto();
        for (Employee emp : byNameOrSurname) {
            employeeDto.setName(emp.getName());
            employeeDto.setSurname(emp.getSurname());
        }
        employeeDtos.add(employeeDto);
        return employeeDtos;
    }

    @Override
    public void update(EmployeeDto employeeDto, Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomRestException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND));
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());

        List<EmployeeAddressesDto> addressesDtos = employeeDto.getEmployeeAddresses();

        List<EmployeeAddresses> addresses = new ArrayList<>();

        for (EmployeeAddressesDto dto : addressesDtos) {
            EmployeeAddresses emp = new EmployeeAddresses();
            emp.setId(dto.getId());
            emp.setLastAddress(dto.getLastAddress());
            emp.setCurrentAddress(dto.getCurrentAddress());

            addresses.add(emp);
        }
        employee.setEmployeeAddresses(addresses);

        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Long count() {
        return employeeRepository.count();
    }

}

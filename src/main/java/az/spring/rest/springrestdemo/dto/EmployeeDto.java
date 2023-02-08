package az.spring.rest.springrestdemo.dto;


import lombok.Data;


import java.util.List;

@Data
public class EmployeeDto {
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private double salary;
    List<EmployeeAddressesDto> employeeAddresses;
}

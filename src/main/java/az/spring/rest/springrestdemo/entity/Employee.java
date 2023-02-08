package az.spring.rest.springrestdemo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private double salary;
    @OneToMany(mappedBy = "employeeId", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    List<EmployeeAddresses> employeeAddresses;

    public Employee() {
    }
}

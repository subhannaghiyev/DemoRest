package az.spring.rest.springrestdemo;

import az.spring.rest.springrestdemo.entity.Employee;
import az.spring.rest.springrestdemo.entity.EmployeeAddresses;
import az.spring.rest.springrestdemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringRestDemoApplication {

    private final EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDemoApplication.class, args);
    }


}

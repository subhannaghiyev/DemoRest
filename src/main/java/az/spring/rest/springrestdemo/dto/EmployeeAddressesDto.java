package az.spring.rest.springrestdemo.dto;

import lombok.Data;


@Data
public class EmployeeAddressesDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String currentAddress;
    private String lastAddress;
}

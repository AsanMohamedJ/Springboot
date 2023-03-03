package com.example.employeefinal.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeRequestDTO {
    private String employeeName;
    private  int contactNo;
    private String address;
    private String emailId;
}

package com.example.employeefinal.dto;

import com.example.employeefinal.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class EmployeeResponseDTO {
    private int employeeId;
    private String employeeName;
    private  int contactNo;
    private String address;
    private String emailId;
    public EmployeeResponseDTO(Employee employee){
        this.setContactNo(employee.getContactNo());
        this.setEmployeeId(employee.getEmployeeId());
        this.setEmployeeName(employee.getEmployeeName());
        this.setAddress(employee.getAddress());
        this.setEmailId(employee.getEmailId());
    }
}

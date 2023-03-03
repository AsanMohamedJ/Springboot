package com.example.employeefinal.model;

import javax.persistence.*;

@Entity
@Table(name="employee_tb")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column(name="NAME")
    private String employeeName;


    private  int contactNo;
    private String address;
    private String emailId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, int
            contactNo, String address, String emailId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.contactNo = contactNo;
        this.address =address;
        this.emailId = emailId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", contactNo=" + contactNo +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}


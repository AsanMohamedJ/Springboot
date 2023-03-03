package com.example.employeefinal.controller;

import com.example.employeefinal.dto.EmployeeRequestDTO;
import com.example.employeefinal.dto.EmployeeResponseDTO;
import com.example.employeefinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<EmployeeResponseDTO> getEmployees(){

        return employeeService.getAllEmployees();
    }
    @PostMapping("/employees")
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.addEmployee(employeeRequestDTO);
    }
    @GetMapping("/employees/{employeeId}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable int employeeId){
        return employeeService.getEmployee(employeeId);
    }
    @PutMapping("/employees/{employeeId}")
    public EmployeeResponseDTO updateEmployeeById(@PathVariable int employeeId,@RequestBody  EmployeeRequestDTO employeeRequestDTO){

        return employeeService.updateEmployee(employeeId,employeeRequestDTO);
    }
    @DeleteMapping("/employees/{employeeId}")
    public EmployeeResponseDTO deleteEmployeeById(@PathVariable int employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }
}

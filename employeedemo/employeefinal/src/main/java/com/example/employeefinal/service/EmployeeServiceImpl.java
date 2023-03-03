package com.example.employeefinal.service;

import com.example.employeefinal.dto.EmployeeRequestDTO;
import com.example.employeefinal.dto.EmployeeResponseDTO;
import com.example.employeefinal.exception.EmployeeNotFoundException;
import com.example.employeefinal.model.Employee;
import com.example.employeefinal.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<EmployeeResponseDTO>();
        employeeResponseDTOList =  employeeList.stream().map((employee)->{
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            employeeResponseDTO.setEmployeeId(employee.getEmployeeId());
            employeeResponseDTO.setEmployeeName(employee.getEmployeeName());
            employeeResponseDTO.setContactNo(employee.getContactNo());
            employeeResponseDTO.setAddress(employee.getAddress());
            employeeResponseDTO.setEmailId(employee.getEmailId());
            return employeeResponseDTO;
        }).collect(Collectors.toList());
        return employeeResponseDTOList;
    }
    @Override
    public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeRequestDTO.getEmployeeName());
        employee.setContactNo(employeeRequestDTO.getContactNo());
        employee.setAddress(employeeRequestDTO.getAddress());
        employee.setEmailId(employeeRequestDTO.getEmailId());
        Employee savedEmployee = employeeRepo.save(employee);
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        employeeResponseDTO.setEmployeeId(savedEmployee.getEmployeeId());
        employeeResponseDTO.setEmployeeName(savedEmployee.getEmployeeName());
        employeeResponseDTO.setContactNo(savedEmployee.getContactNo());
        employeeResponseDTO.setAddress(savedEmployee.getAddress());
        employeeResponseDTO.setEmailId(savedEmployee.getEmailId());
        return employeeResponseDTO;
    }
    @Override
    public EmployeeResponseDTO getEmployee(int employeeId) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if(employeeOptional.isPresent()){
            Employee searchedEmployee =  employeeOptional.get();
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            employeeResponseDTO.setEmployeeId(searchedEmployee.getEmployeeId());
            employeeResponseDTO.setEmployeeName(searchedEmployee.getEmployeeName());
            employeeResponseDTO.setContactNo(searchedEmployee.getContactNo());
            employeeResponseDTO.setAddress(searchedEmployee.getAddress());
            employeeResponseDTO.setEmailId(searchedEmployee.getEmailId());
            return employeeResponseDTO;
        }else{
            throw new EmployeeNotFoundException("The Employee with ID : "+employeeId + " is not present.");
        }
    }
    @Override
    public EmployeeResponseDTO updateEmployee(int employeeId, EmployeeRequestDTO employeeRequestDTO) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if(employeeOptional.isPresent()){
            //If present then updation will happen
            Employee searchedEmployee = employeeOptional.get();
            searchedEmployee.setEmployeeName(employeeRequestDTO.getEmployeeName());
            searchedEmployee.setContactNo(employeeRequestDTO.getContactNo());
            searchedEmployee.setAddress(employeeRequestDTO.getAddress());
            searchedEmployee.setEmailId(employeeRequestDTO.getEmailId());
            employeeRepo.flush();
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            employeeResponseDTO.setEmployeeId(searchedEmployee.getEmployeeId());
            employeeResponseDTO.setEmployeeName(searchedEmployee.getEmployeeName());
            employeeResponseDTO.setContactNo(searchedEmployee.getContactNo());
            employeeResponseDTO.setAddress(searchedEmployee.getAddress());
            employeeResponseDTO.setEmailId(searchedEmployee.getEmailId());
            return employeeResponseDTO;
        }else{
            //A new book will be created
            Employee newEmployee = new Employee();
            newEmployee.setEmployeeName(employeeRequestDTO.getEmployeeName());
            newEmployee.setEmailId(employeeRequestDTO.getEmailId());
            newEmployee.setAddress(employeeRequestDTO.getAddress());
            newEmployee.setContactNo(employeeRequestDTO.getContactNo());
            Employee savedEmp = employeeRepo.save(newEmployee);
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
            employeeResponseDTO.setEmployeeId(savedEmp.getEmployeeId());
            employeeResponseDTO.setEmployeeName(savedEmp.getEmployeeName());
            employeeResponseDTO.setContactNo(savedEmp.getContactNo());
            employeeResponseDTO.setAddress(savedEmp.getAddress());
            employeeResponseDTO.setEmailId(savedEmp.getEmailId());
            return employeeResponseDTO;
        }
    }
    @Override
    public EmployeeResponseDTO deleteEmployeeById(int employeeId) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if(employeeOptional.isPresent()){
            Employee deletedEmp = employeeOptional.get();
            employeeRepo.delete(deletedEmp);
            EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO(deletedEmp);
            return employeeResponseDTO;
        }else{
            throw new EmployeeNotFoundException("Employee having ID : "+employeeId+ " not present in DB");
        }
    }
}
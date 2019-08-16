package com.demo.controller;

import com.demo.constants.RequestConstants;
import com.demo.dto.EmployeeRequest;
import com.demo.dto.EmployeeUpdateRequest;
import com.demo.entity.Employee;
import com.demo.resonse.GenericResponse;
import com.demo.resonse.ListResponse;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/create/employee")
    GenericResponse registerEmployee(@RequestBody EmployeeRequest employeeRequest) {
        GenericResponse genericResponse = employeeRequest.validate();
        if (genericResponse.isException()) {
            return genericResponse;
        }
        return employeeService.createEmployee(employeeRequest);
    }

    @GetMapping(value = "/getAll/employee")
    ListResponse getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/get/employee/{employeeCode}")
    ListResponse getEmployeeById(@PathVariable(name = RequestConstants.EMPLOYEE_CODE) String employeeCode) {
        ListResponse listResponse = new ListResponse();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeService.getEmployeeByEmpId(employeeCode));
        listResponse.setEmployeeList(employeeList);
        return listResponse;
    }

    @PatchMapping(value = "/update/employee/{employeeCode}")
    GenericResponse updateEmployee(@PathVariable(name = RequestConstants.EMPLOYEE_CODE) String employeeCode,
                                   @RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
        GenericResponse genericResponse = employeeUpdateRequest.validate();
        if (genericResponse.isException()) {
            return genericResponse;
        }
        return employeeService.updateEmployee(employeeUpdateRequest, employeeCode);
    }

    @DeleteMapping(value="/delete/employee/{employeeCode}")
    GenericResponse deleteEmployee(@PathVariable(name=RequestConstants.EMPLOYEE_CODE)String employeeCode){
        return employeeService.deleteEmployee(employeeCode);
    }
}

package com.demo.service;

import com.demo.dto.EmployeeRequest;
import com.demo.dto.EmployeeUpdateRequest;
import com.demo.entity.Employee;
import com.demo.resonse.GenericResponse;
import com.demo.resonse.ListResponse;

public interface EmployeeService {

    Employee getEmployeeByEmpId(String empCode);

    GenericResponse createEmployee(EmployeeRequest empRequest);

    ListResponse getAllEmployees();

    GenericResponse updateEmployee(EmployeeUpdateRequest employeeUpdateRequest, String employeeCode);

    GenericResponse deleteEmployee(String employeeCode);
}

package com.demo.serviceImpl;

import com.demo.core.Helper;
import com.demo.dto.EmployeeRequest;
import com.demo.dto.EmployeeUpdateRequest;
import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.resonse.GenericResponse;
import com.demo.resonse.ListResponse;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByEmpId(String empCode) {
        return employeeRepository.findByEmployeeCode(empCode);
    }

    @Override
    public GenericResponse createEmployee(EmployeeRequest empRequest) {
        Employee employee = getEmployeeByEmpId(empRequest.getEmployeeId());
        if (employee != null) {
            return Helper.getGenericResponse(true, Arrays.asList(new String[]{"" + empRequest.getEmployeeId() + " empId already exists "}));
        }
        employee = empRequest.sync();
        employeeRepository.save(employee);
        return Helper.getGenericResponse(false, Arrays.asList(new String[]{"Employee created successfully"}));
    }

    @Override
    public ListResponse getAllEmployees() {
        ListResponse response = new ListResponse();
        response.setEmployeeList((List<Employee>) employeeRepository.findAll());
        return response;
    }

    @Override
    public GenericResponse updateEmployee(EmployeeUpdateRequest employeeUpdateRequest, String employeeCode) {
        Employee employee = getEmployeeByEmpId(employeeCode);
        if (employee == null) {
            return Helper.getGenericResponse(true, Arrays.asList(new String[]{"Employee doesn't exist for empCode " + employeeCode}));
        }
        Long phoneRequest = Long.parseLong(employeeUpdateRequest.getPhone());
        if (employeeUpdateRequest.getName().equals(employee.getName()) && employee.getPhone().equals(phoneRequest)) {
            return Helper.getGenericResponse(false, Arrays.asList(new String[]{"Same data exists for empCode " + employeeCode}));
        }
        employee.setName(employeeUpdateRequest.getName());
        employee.setPhone(phoneRequest);
        employeeRepository.save(employee);
        return Helper.getGenericResponse(false, Arrays.asList(new String[]{"Employee updated succesfully"}));
    }

    @Override
    public GenericResponse deleteEmployee(String employeeCode) {
        Employee employee = getEmployeeByEmpId(employeeCode);
        if (employee == null) {
            return Helper.getGenericResponse(false, Arrays.asList(new String[]{"Employee doesn't exists for emplCode " + employeeCode}));
        }
        employeeRepository.delete(employee);
        return Helper.getGenericResponse(false, Arrays.asList(new String[]{"Employee deleted successfully"}));
    }
}

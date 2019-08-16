package com.demo.dto;


import com.demo.core.Helper;
import com.demo.entity.Employee;
import com.demo.resonse.GenericResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class EmployeeRequest {
    private String name;
    private String email;
    private String phone;
    private String employeeId;
    private String designation;

    public EmployeeRequest(String name, String email, String phone, String employeeId, String designation) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.employeeId = employeeId;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    public GenericResponse validate() {

        if (StringUtils.isBlank(this.email) || StringUtils.isBlank(this.name)) {
            return Helper.getGenericResponse(true, Arrays.asList(new String[]{"Either email or name is empty"}));
        }
        if (StringUtils.isNotBlank(this.phone)) {
            if (this.phone.length() != 10 || !StringUtils.isNumeric(this.phone)) {
                return Helper.getGenericResponse(true, Arrays.asList(new String[]{"Invalid Phone Number"}));
            }
        }
        return new GenericResponse();
    }

    public Employee sync() {
        Employee employee = new Employee();
        employee.setName(this.name);
        employee.setEmail(this.email);
        employee.setEmployeeCode(this.employeeId);
        employee.setPhone(Long.parseLong(this.phone));
        employee.setDesignation(this.designation);
        return employee;
    }
}

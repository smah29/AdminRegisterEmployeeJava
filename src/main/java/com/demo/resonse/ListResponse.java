package com.demo.resonse;

import com.demo.constants.DtoJsonConstants;
import com.demo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListResponse extends GenericResponse {
    List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    protected List<String> getKeys() {
        List<String> keys = super.getKeys();
        keys.add(DtoJsonConstants.LIST);
        return keys;
    }

    @Override
    protected List<Object> getValues() {
        List<Object> values = super.getValues();
        values.add(this.employeeList);
        return values;
    }

}

package com.demo.dto;


import com.demo.core.Helper;
import com.demo.resonse.GenericResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class EmployeeUpdateRequest {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public GenericResponse validate() {
        if (StringUtils.isBlank(this.name)) {
            return Helper.getGenericResponse(true, Arrays.asList(new String[]{"Name is blank"}));
        }
        if (StringUtils.isNotBlank(this.phone)) {
            if (this.phone.length() != 10 || !StringUtils.isNumeric(this.phone)) {
                return Helper.getGenericResponse(true, Arrays.asList(new String[]{"Invalid Phone"}));
            }
        }
        return new GenericResponse();
    }
}

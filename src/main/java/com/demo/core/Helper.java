package com.demo.core;

import com.demo.resonse.GenericResponse;

import java.util.List;

public class Helper {

    public static GenericResponse getGenericResponse(boolean isException, List<String> msgs) {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setException(isException);
        genericResponse.setMessages(msgs);
        return genericResponse;
    }
}

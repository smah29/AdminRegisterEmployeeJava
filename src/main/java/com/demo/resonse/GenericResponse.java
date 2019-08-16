package com.demo.resonse;


import com.demo.constants.DtoJsonConstants;
import com.demo.core.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GenericResponse extends JSONObject {
    protected boolean exception = false;
    protected List<String> messages = new ArrayList<String>();

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    protected List<String> getKeys() {
        List<String> keys = new ArrayList<String>();
        keys.add(DtoJsonConstants.MESSAGES);
        keys.add(DtoJsonConstants.EXCEPTION);

        return keys;
    }

    @Override
    protected List<Object> getValues() {
        List<Object> values = new ArrayList<Object>();
        values.add(this.messages);
        values.add(this.exception);
        return values;
    }
}

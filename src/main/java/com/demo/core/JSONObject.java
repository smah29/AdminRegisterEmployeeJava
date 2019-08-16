package com.demo.core;

import java.io.Serializable;
import java.util.List;

public abstract class JSONObject implements Serializable, Cloneable {
    protected abstract List<String> getKeys();

    protected abstract List<Object> getValues();
}

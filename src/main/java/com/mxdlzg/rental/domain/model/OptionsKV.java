package com.mxdlzg.rental.domain.model;

import java.io.Serializable;

public class OptionsKV<T> implements Serializable {
    private String Label;
    private T Value;

    public OptionsKV(String label, T value) {
        Label = label;
        Value = value;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }
}

package com.mxdlzg.rental.domain.model;

public class OptionsKV {
    private String Label,Value;

    public OptionsKV(String label, String value) {
        Label = label;
        Value = value;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}

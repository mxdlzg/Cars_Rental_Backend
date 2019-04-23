package com.mxdlzg.rental.domain.model;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

public class OptionsCar {
    private String Key,Value,Type;
    private boolean Selected;

    public OptionsCar(String key, String value, String type, boolean selected) {
        Key = key;
        Value = value;
        Type = type;
        Selected = selected;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }
}

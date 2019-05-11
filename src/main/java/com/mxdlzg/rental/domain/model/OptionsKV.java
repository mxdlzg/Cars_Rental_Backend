package com.mxdlzg.rental.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class OptionsKV<T> implements Serializable {
    private String Label;
    private T Value;

    public OptionsKV(String label, T value) {
        Label = label;
        Value = value;
    }

    public OptionsKV(int dayOf,T value,String type){
        switch (type){
            case "week":
                this.Label = "周"+dayOf;
                this.Value = value;
                break;
            case "month":
                this.Label = "第"+dayOf+"天";
                this.Value = value;
                break;
            case "year":
                this.Label = "第"+dayOf+"月";
                this.Value = value;
                break;
        }
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

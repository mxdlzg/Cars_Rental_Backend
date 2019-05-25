package com.mxdlzg.rental.domain.model;

import java.io.Serializable;

public class OptionsXY<T> implements Serializable {
    private String X;
    private T Y;

    public OptionsXY(String x, T y) {
        X = x;
        Y = y;
    }

    public OptionsXY(int dayOf, T y, String type){
        switch (type){
            case "week":
                this.X = "周"+dayOf;
                this.Y = y;
                break;
            case "month":
                this.X = "第"+dayOf+"天";
                this.Y = y;
                break;
            case "year":
                this.X = "第"+dayOf+"月";
                this.Y = y;
                break;
        }
    }



    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public T getY() {
        return Y;
    }

    public void setY(T y) {
        Y = y;
    }

}

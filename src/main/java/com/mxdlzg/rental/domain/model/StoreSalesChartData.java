package com.mxdlzg.rental.domain.model;

public class StoreSalesChartData {
    private Long x;
    private Long y1,y2;

    public StoreSalesChartData(Long x, Long y1, Long y2) {
        this.x = x;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY1() {
        return y1;
    }

    public void setY1(Long y1) {
        this.y1 = y1;
    }

    public Long getY2() {
        return y2;
    }

    public void setY2(Long y2) {
        this.y2 = y2;
    }
}

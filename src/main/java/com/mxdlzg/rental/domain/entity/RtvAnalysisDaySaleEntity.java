package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rtv_analysis_day_sale", schema = "rental", catalog = "")
public class RtvAnalysisDaySaleEntity {
    private Double dayTotal;
    private long dayPaidCount;
    private String dayTime;
    private Integer dayOfWeek;
    private Integer dayOfMonth;
    private Integer monthOfYear;

    @Basic
    @Column(name = "day_total", nullable = true, precision = 2)
    public Double getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(Double dayTotal) {
        this.dayTotal = dayTotal;
    }

    @Basic
    @Column(name = "day_paid_count", nullable = false)
    public long getDayPaidCount() {
        return dayPaidCount;
    }

    public void setDayPaidCount(long dayPaidCount) {
        this.dayPaidCount = dayPaidCount;
    }

    @Basic
    @Id
    @Column(name = "day_time", nullable = true, length = 10)
    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvAnalysisDaySaleEntity that = (RtvAnalysisDaySaleEntity) o;
        return dayPaidCount == that.dayPaidCount &&
                Objects.equals(dayTotal, that.dayTotal) &&
                Objects.equals(dayTime, that.dayTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayTotal, dayPaidCount, dayTime);
    }

    @Basic
    @Column(name = "day_of_week", nullable = true)
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Basic
    @Column(name = "day_of_month", nullable = true)
    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Basic
    @Column(name = "month_of_year", nullable = true)
    public Integer getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(Integer monthOfYear) {
        this.monthOfYear = monthOfYear;
    }
}

package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rtv_analysis_day_access", schema = "rental", catalog = "")
public class RtvAnalysisDayAccessEntity {
    private Date date;
    private long count;

    @Id
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvAnalysisDayAccessEntity that = (RtvAnalysisDayAccessEntity) o;
        return count == that.count &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, count);
    }
}

package com.mxdlzg.rental.domain.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentsMdl {
    @NotNull
    @NotEmpty
    private String content;
    @NotNull
    @Min(0)
    @Max(5)
    private Integer rate;
    @NotNull
    @NotEmpty
    private String order;

    public CommentsMdl() {
    }

    public CommentsMdl(@NotNull @NotEmpty String content, @NotNull @Min(0) @Max(5) Integer rate, @NotNull String order) {
        this.content = content;
        this.rate = rate;
        this.order = order;
    }


    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}

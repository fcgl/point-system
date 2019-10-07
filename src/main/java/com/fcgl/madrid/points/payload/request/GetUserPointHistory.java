package com.fcgl.madrid.points.payload.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class GetUserPointHistory {

    @NotNull
    private Integer page;
    @NotNull
    private Integer size;
    @NotNull
    private Long userId;

    public GetUserPointHistory(Integer page, Integer size, Long userId) {
        this.page = page;
        this.size = size;
        this.userId = userId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

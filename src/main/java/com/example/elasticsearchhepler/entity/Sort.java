package com.example.elasticsearchhepler.entity;

import com.example.elasticsearchhepler.enums.SortEnum;

import java.io.Serializable;

public class Sort implements Serializable {
    private static final long serialVersionUID = -3304075232976302096L;

    public Sort() {
    }

    public Sort(String fieldName, SortEnum order) {
        this.fieldName = fieldName;
        this.order = order;
    }

    private String fieldName;
    private SortEnum order;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public SortEnum getOrder() {
        return order;
    }

    public void setOrder(SortEnum order) {
        this.order = order;
    }
}

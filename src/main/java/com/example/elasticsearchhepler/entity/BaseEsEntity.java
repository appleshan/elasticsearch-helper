package com.example.elasticsearchhepler.entity;

import com.example.elasticsearchhepler.annotations.ESField;
import com.example.elasticsearchhepler.annotations.ESID;

import java.io.Serializable;

public class BaseEsEntity implements Serializable {
    private static final long serialVersionUID = 3739635447774514531L;
    /**
     * 业务数据主键
     */
    @ESID
    @ESField(name = "id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
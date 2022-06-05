package com.example.elasticsearchhepler.entity;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;

import java.io.Serializable;

/**
 * 批量操作返回结果实体
 */
public class BulkResponseResult implements Serializable {
    private static final long serialVersionUID = 547402260621429004L;

    public BulkResponseResult() {
    }

    public BulkResponseResult(Integer indexNum, DocWriteRequest.OpType opType, String indexName, String id,
                              DocWriteResponse.Result result, boolean failedFlag, String failureMessage) {
        this.indexNum = indexNum;
        this.opType = opType;
        this.indexName = indexName;
        this.id = id;
        this.result = result;
        this.failedFlag = failedFlag;
        this.failureMessage = failureMessage;
    }

    //数据在合集中的下标位置
    private Integer indexNum;

    //操作类型
    private DocWriteRequest.OpType opType;

    //索引名
    private String indexName;

    //数据id（有值可认为操作成功）
    private String id;

    //返回结果
    private DocWriteResponse.Result result;

    //是否失败 false:没有失败  true：操作失败
    private boolean failedFlag;

    //失败原因
    private String failureMessage;

    public Integer getIndexNum() {
        return indexNum;
    }

    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }

    public DocWriteRequest.OpType getOpType() {
        return opType;
    }

    public void setOpType(DocWriteRequest.OpType opType) {
        this.opType = opType;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocWriteResponse.Result getResult() {
        return result;
    }

    public void setResult(DocWriteResponse.Result result) {
        this.result = result;
    }

    public boolean isFailedFlag() {
        return failedFlag;
    }

    public void setFailedFlag(boolean failedFlag) {
        this.failedFlag = failedFlag;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}

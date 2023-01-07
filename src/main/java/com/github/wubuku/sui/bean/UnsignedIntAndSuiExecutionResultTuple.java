package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = UnsignedIntAndSuiExecutionResultTupleDeserializer.class)
@JsonSerialize(using = UnsignedIntAndSuiExecutionResultTupleSerializer.class)
public class UnsignedIntAndSuiExecutionResultTuple {
    private Long unsignedInt;
    private SuiExecutionResult suiExecutionResult;

    public UnsignedIntAndSuiExecutionResultTuple() {
    }

    public UnsignedIntAndSuiExecutionResultTuple(Long unsignedInt, SuiExecutionResult suiExecutionResult) {
        this.unsignedInt = unsignedInt;
        this.suiExecutionResult = suiExecutionResult;
    }

    public Long getUnsignedInt() {
        return unsignedInt;
    }

    public void setUnsignedInt(Long unsignedInt) {
        this.unsignedInt = unsignedInt;
    }

    public SuiExecutionResult getSuiExecutionResult() {
        return suiExecutionResult;
    }

    public void setSuiExecutionResult(SuiExecutionResult suiExecutionResult) {
        this.suiExecutionResult = suiExecutionResult;
    }

    @Override
    public String toString() {
        return "UnsignedIntAndSuiExecutionResultTuple{" +
                "unsignedInt=" + unsignedInt +
                ", suiExecutionResult=" + suiExecutionResult +
                '}';
    }
}

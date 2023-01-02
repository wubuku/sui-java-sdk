package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type ExecutionStatus = {
 *   status: ExecutionStatusType;
 *   error?: string;
 * };
 * </pre>
 */
public class ExecutionStatus {
    private ExecutionStatusType status;
    private String error;

    public ExecutionStatus() {
    }

    public ExecutionStatus(ExecutionStatusType status, String error) {
        this.status = status;
        this.error = error;
    }

    public ExecutionStatusType getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatusType status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ExecutionStatus{" +
                "status=" + status +
                ", error='" + error + '\'' +
                '}';
    }
}

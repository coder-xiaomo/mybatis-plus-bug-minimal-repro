package com.example.backend.common.Response;

public enum CommonReturnTypeStatus {
    SUCCESS("success"),
    FAILED("fail");

    private String str;

    private CommonReturnTypeStatus(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
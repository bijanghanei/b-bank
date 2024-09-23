package com.bijanghanei.transactionservice.entity;

public enum TransactionType {
    DEPOSIT((byte) 0),
    WITHDRAWAL((byte) 1);
    final byte code;

    TransactionType(byte code) {
        this.code = code;
    }
    public Byte getCode() {
        return this.code;
    }
}

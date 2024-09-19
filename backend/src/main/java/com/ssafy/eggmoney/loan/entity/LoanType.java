package com.ssafy.eggmoney.loan.entity;

public enum LoanType {
    EQUALR("원리금균등상환"), LUMPSUM("만기일시상환");

    final String value;

    LoanType(String value) {
        this.value = value;
    }
}
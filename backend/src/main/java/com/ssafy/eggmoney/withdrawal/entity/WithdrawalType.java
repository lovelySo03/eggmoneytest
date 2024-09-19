package com.ssafy.eggmoney.withdrawal.entity;

import lombok.Getter;

@Getter
public enum WithdrawalType {
    ALLOW("승인"),
    REJECT("거절"),
    CHECK("진행중");

    private final String type;

    private WithdrawalType(String type) {
        this.type = type;
    }
}

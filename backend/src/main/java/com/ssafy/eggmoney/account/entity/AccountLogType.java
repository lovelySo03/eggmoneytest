package com.ssafy.eggmoney.account.entity;

import lombok.Getter;

@Getter
public enum AccountLogType {
//    아래 부분에 로그 유형 추가
//    자산
    WITHDRAWL("출금"),
    SAVINGS("적금"),
    DEPOSIT("예금"),
    ALLOWANCE("용돈"),
    LOAN("대출"),
    STOCK("주식");

//    금융
//    증권
//    전체

    private String logType;

    AccountLogType(String logType) {
        this.logType = logType;
    }
}

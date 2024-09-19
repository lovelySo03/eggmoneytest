package com.ssafy.eggmoney.withdrawal.dto.request;

import lombok.Getter;

@Getter
public class CreateWithdrawalRequestDto {
    Long userId;
    int price;
}

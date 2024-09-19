package com.ssafy.eggmoney.deposit.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepositCreateRequestDto {
    private long userId;
    private int depositMoney;
    private long depositProductId;
}

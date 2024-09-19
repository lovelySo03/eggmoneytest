package com.ssafy.eggmoney.deposit.dto.responsedto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepositProductListResponseDto {
    private Long productId;
    private int depositDate;
    private Double depositRate;
}

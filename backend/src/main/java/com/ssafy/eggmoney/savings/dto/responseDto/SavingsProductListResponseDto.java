package com.ssafy.eggmoney.savings.dto.responseDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SavingsProductListResponseDto {
    private Long id;
    private int savingsDate;
    private Double savingsRate;
    private int max_price;
}

package com.ssafy.eggmoney.savings.dto.responseDto;

import com.ssafy.eggmoney.savings.entity.SavingsProduct;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class SavingsResponseDto {
    private int savingsDate; // savingsProduct 기간(개월수)
    private Double savingsRate; // savingsProduct 이율
    private int balance;
    private LocalDateTime expireDate;
    private LocalDateTime createdAt;
    private int paymentDate;
    private int paymentMoney;

}

package com.ssafy.eggmoney.savings.dto.responseDto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class SavingsLogResponseDto {
    // 피그마 로그 페이지에 들어가는 것
    /*
    * 회차, 현재 적금 통장의 돈, 적금넣는 돈, 넣는 날짜
    * 그냥 날짜, 현재 적금통장의 돈이 잔금, 적금 넣는 돈은 넘어올것임. savings로
    * 따라서 savingsId로 받아서 로그 찍어주기
    * */

    private LocalDateTime createdAt;
    private int paymentMoney;
    private int balance;





}


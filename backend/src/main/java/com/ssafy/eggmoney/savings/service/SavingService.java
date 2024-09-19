package com.ssafy.eggmoney.savings.service;

import com.ssafy.eggmoney.savings.dto.requestDto.SavingsCreateRequestDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsLogResponseDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsProductListResponseDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsResponseDto;

import java.util.List;

public interface SavingService {
    List<SavingsProductListResponseDto> getSavingProducts();
    void createSaving(SavingsCreateRequestDto savingsCreateRequestDto);
    SavingsResponseDto getSavings(Long userId);
    void sendSavings(Long userId);
    List<SavingsLogResponseDto> getSavingsLogs(Long savingsId);
}

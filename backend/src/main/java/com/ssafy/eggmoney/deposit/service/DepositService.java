package com.ssafy.eggmoney.deposit.service;

import com.ssafy.eggmoney.deposit.dto.requestdto.DepositCreateRequestDto;
import com.ssafy.eggmoney.deposit.dto.responsedto.DepositProductListResponseDto;
import com.ssafy.eggmoney.deposit.dto.responsedto.DepositResponseDto;

import java.util.List;

public interface DepositService {
    void createDeposit(DepositCreateRequestDto requestDto);
    DepositResponseDto getDeposits(long id);
    List<DepositProductListResponseDto> getDepositProducts();
}

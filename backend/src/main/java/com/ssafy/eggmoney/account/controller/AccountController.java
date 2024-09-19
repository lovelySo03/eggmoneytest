package com.ssafy.eggmoney.account.controller;

import com.ssafy.eggmoney.account.dto.responseDto.GetAccountResponseDto;
import com.ssafy.eggmoney.account.entity.AccountLog;
import com.ssafy.eggmoney.account.service.AccountLogService;
import com.ssafy.eggmoney.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/asset/main-account")
public class AccountController {
    private final AccountService accountService;
    private final AccountLogService accountLogService;

//    메인계좌 조회
    @GetMapping("/{userId}")
    public GetAccountResponseDto getAccount(@PathVariable("userId") Long userId){

        return accountService.getAccount(userId);
    }

//    메인계좌 로그 조회
    @PostMapping("/{userId}/log")
    public List<AccountLog> getAccountLogs(@PathVariable("userId") Long userId){
        return accountLogService.getAccountLogs(userId);
    }

}

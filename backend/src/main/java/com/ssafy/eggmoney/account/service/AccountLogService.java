package com.ssafy.eggmoney.account.service;

import com.ssafy.eggmoney.account.entity.Account;
import com.ssafy.eggmoney.account.entity.AccountLog;
import com.ssafy.eggmoney.account.entity.AccountLogType;
import com.ssafy.eggmoney.account.repository.AccountLogRepository;
import com.ssafy.eggmoney.account.repository.AccountRepository;
import com.ssafy.eggmoney.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountLogService {
    private final AccountLogRepository accountLogRepository;
    private final AccountRepository accountRepository;


//    메인계좌 로그 조회
    public List<AccountLog> getAccountLogs(Long userId){
        return accountLogRepository.findLogsByAccountId(userId);
    }

//    메인계좌 로그 생성
    public void createAccountLog(Long userId, AccountLogType logType, int price) {
        Account account = accountRepository.findByUserId(userId).get();

        accountLogRepository.save(
                AccountLog.builder()
                        .account(account)
                        .currentBalance(account.getBalance() + price)
                        .tradeTarget(logType)
                        .tradePrice(price)
                        .build()
        );
    }

//

}

package com.ssafy.eggmoney.account.service;

import com.ssafy.eggmoney.account.dto.responseDto.GetAccountResponseDto;
import com.ssafy.eggmoney.account.entity.Account;
import com.ssafy.eggmoney.account.entity.AccountLogType;
import com.ssafy.eggmoney.account.repository.AccountLogRepository;
import com.ssafy.eggmoney.account.repository.AccountRepository;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountLogRepository accountLogRepository;
    private final AccountLogService accountLogService;
    private final UserRepository userRepository;

//    내 메인 계좌 조회
    public GetAccountResponseDto getAccount(Long userId) {
        Optional<User> ou =  userRepository.findById(userId);

        if ( ou.isEmpty() )
            throw new RuntimeException();

        User us = ou.get();
        Account ac = accountRepository.findByUserId(us.getId()).get();
        GetAccountResponseDto getAccountResponseDto = GetAccountResponseDto.builder()
                .userId(us.getId())
                .balance(ac.getBalance())
                .build();

        return getAccountResponseDto;
    }

//    메인 계좌 생성
    public void createAccount(Long userId) {
        System.out.println("user "+ userId + "의 메인 계좌 생성 완료");
        accountRepository.save(Account
                .builder()
                        .user(userRepository.findById(userId).orElse(null))
                        .balance(0)
                .build()
        );
    }

//    메인 계좌 입출금
    public void updateAccount(AccountLogType type, Long userId, int price) {
//        로그 생성
        accountLogService.createAccountLog(userId, type, price);
//        계좌에 입출금 반영
        Account account = accountRepository.findByUserId(userId).get();
        account.setBalance( account.getBalance() + price );
        accountRepository.save(account);
    }

}

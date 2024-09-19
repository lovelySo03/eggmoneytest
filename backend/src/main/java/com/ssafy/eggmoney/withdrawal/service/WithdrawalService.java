package com.ssafy.eggmoney.withdrawal.service;

import com.ssafy.eggmoney.account.entity.Account;
import com.ssafy.eggmoney.account.entity.AccountLogType;
import com.ssafy.eggmoney.account.repository.AccountRepository;
import com.ssafy.eggmoney.account.service.AccountService;
import com.ssafy.eggmoney.family.dto.response.GetFamilyResponseDto;
import com.ssafy.eggmoney.family.entity.Family;
import com.ssafy.eggmoney.family.repository.FamilyRepository;
import com.ssafy.eggmoney.user.dto.response.GetUserResponseDto;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.user.repository.UserRepository;
import com.ssafy.eggmoney.withdrawal.dto.request.CreateWithdrawalRequestDto;
import com.ssafy.eggmoney.withdrawal.dto.request.GetWithdrawalRequestDto;
import com.ssafy.eggmoney.withdrawal.dto.request.JudgeWithdrawalRequestDto;
import com.ssafy.eggmoney.withdrawal.dto.response.GetWithdrawalResponseDto;
import com.ssafy.eggmoney.withdrawal.entity.Withdrawal;
import com.ssafy.eggmoney.withdrawal.entity.WithdrawalStatus;
import com.ssafy.eggmoney.withdrawal.entity.WithdrawalType;
import com.ssafy.eggmoney.withdrawal.repository.WithdrawalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class WithdrawalService {
    private final WithdrawalRepository withdrawalRepository;
    private final UserRepository userRepository;
    private final AccountService accountService;
    private final AccountRepository accountRepository;

//  출금요청 로그 조회
    public List<GetWithdrawalResponseDto> getWithdrawalLogs(GetWithdrawalRequestDto dto){
        User child = userRepository.findById(dto.getUserId()).get();
        User parent = userRepository.findById(child.getFamily().getPresentId()).get();
        List<Withdrawal> lst = withdrawalRepository.findLogsByUserId(child.getId());
        Family childFam = child.getFamily();
        Family parentFam = parent.getFamily();

        List<GetWithdrawalResponseDto> logs = lst.stream()
                .map( withdrawal -> GetWithdrawalResponseDto.builder()
                    .applyer(
                            GetUserResponseDto.builder()
                                    .email(child.getEmail())
                                    .role(child.getRole())
                                    .family(
                                            GetFamilyResponseDto.builder()
                                                    .presentId(parentFam.getPresentId())
                                                    .intro(parentFam.getIntro())
                                                    .qrcode(parentFam.getQrCode())
                                                    .build()
                                    )
                                    .bank(child.getBank())
                                    .pwd(child.getSimplePwd())
                                    .realAccount(child.getRealAccount())
                                    .name(child.getName())
                                    .stockRatio(child.getStockRatio())
                                    .build()
                    )
                    .applyee(
                            GetUserResponseDto.builder()
                            .email(parent.getEmail())
                            .family(
                                    GetFamilyResponseDto.builder()
                                        .presentId(childFam.getPresentId())
                                        .intro(childFam.getIntro())
                                        .qrcode(childFam.getQrCode())
                                    .build())
                            .role(parent.getRole())
                            .bank(parent.getBank())
                            .pwd(parent.getSimplePwd())
                            .realAccount(parent.getRealAccount())
                            .name(parent.getName())
                            .stockRatio(parent.getStockRatio())
                            .build())
                    .withdrawalPrice(withdrawal.getWithdrawalPrice())
                    .type(withdrawal.getWithdrawalStatus())
                .build()
                )
                .collect(Collectors.toList());

        return logs;
    }

//  출금요청 생성
    public void createWithdrawal(CreateWithdrawalRequestDto dto){
        User user = userRepository.findById(dto.getUserId()).get();

        Account account = accountRepository.findByUserId(user.getId()).get();

        System.out.println("Acc Bal : "+account.getBalance()+"/ dto Bal"+dto.getPrice());
//        예외처리 : 계좌에 출금요청할 돈 있어야 함
        if ( account.getBalance() - dto.getPrice() < 0 ) {
            System.out.println("돈 부족");
            return;
        }
        
        withdrawalRepository.save(
                Withdrawal.builder()
                    .user(user)
                    .withdrawalStatus(WithdrawalStatus.APPROVAL)
                    .withdrawalPrice(dto.getPrice())
                .build()
        );

    }

//    출금 심사
    public void judgeWithdrawal(Long Wid, JudgeWithdrawalRequestDto dto){
        Withdrawal with = withdrawalRepository.findById(Wid).get();
        String judge = dto.getJudge();

//        예외처리: 부모가 아닌데 심사하려는 경우
        if ( dto.getUserId() != with.getUser().getFamily().getPresentId() ) {
            System.out.println("권한이 없습니다.");
            return;
        }
//        예외처리: judge가 null값
        if ( judge == null )
            return;
//        예외처리: 이미 심사가 이루어진 상태
        if ( with.getWithdrawalStatus() != WithdrawalStatus.PROGRESS ) {
            System.out.println("이미 심사됨");
            return;
        }

//      승인
        if ( judge.equals("승인") ) {
            with.setWithdrawalStatus(WithdrawalStatus.APPROVAL);
            accountService.updateAccount(AccountLogType.WITHDRAWL, with.getUser().getId(), -with.getWithdrawalPrice());
        }

//      거절
        else {
            with.setWithdrawalStatus(WithdrawalStatus.REFUSAL);
        }
    }

}

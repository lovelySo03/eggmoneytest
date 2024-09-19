package com.ssafy.eggmoney.savings.service;

import com.ssafy.eggmoney.account.entity.AccountLogType;
import com.ssafy.eggmoney.account.service.AccountService;
import com.ssafy.eggmoney.savings.dto.requestDto.SavingsCreateRequestDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsLogResponseDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsProductListResponseDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsResponseDto;
import com.ssafy.eggmoney.savings.entity.Savings;
import com.ssafy.eggmoney.savings.entity.SavingsLog;
import com.ssafy.eggmoney.savings.entity.SavingsProduct;
import com.ssafy.eggmoney.savings.repository.SavingsLogRepository;
import com.ssafy.eggmoney.savings.repository.SavingsProductRepository;
import com.ssafy.eggmoney.savings.repository.SavingsRepository;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SavingServiceImpl implements SavingService {

    private final SavingsRepository savingsRepository;
    private final SavingsProductRepository savingsProductRepository;
    private final SavingsLogRepository savingsLogRepository;
    private final UserRepository userRepository;
    private final AccountService accountService;

    @Override
    @Transactional(readOnly = true)
    public List<SavingsProductListResponseDto> getSavingProducts() {
        List<SavingsProduct> productList =  savingsProductRepository.findAll();

        List<SavingsProductListResponseDto> productListDto = productList.stream().map(
                (product) -> SavingsProductListResponseDto.builder()
                        .id(product.getId())
                        .savingsRate(product.getSavingsRate())
                        .savingsDate(product.getSavingsDate())
                        .max_price(product.getMaxPrice())
                        .build()
                ).collect(Collectors.toList());

        log.info("적금 상품 리스트 조회");
        return productListDto;
    }

    @Override
    @Transactional()
    public void createSaving(SavingsCreateRequestDto requestDto){

        User user = userRepository.findById(requestDto.getUserId()).orElse(null);
        SavingsProduct savingsProduct = savingsProductRepository.findById(requestDto.getSavingsProductId()).orElse(null);

        if(!user.getRole().equals("자녀")){
            // 에러발생
            log.error("적금 가입 권한이 없는 유저입니다.");
        }

        if(savingsRepository.findByUserId(requestDto.getUserId()).isPresent()){
            // 에러발생
            log.error("이미 사용자가 적금상품을 가지고 있습니다.");
        }

        if(savingsProduct.getMaxPrice() < requestDto.getPaymentMoney() * savingsProduct.getSavingsDate()){
            log.error("적금 최대 납입 금액을 넘는 값입니다.");
        }

        Savings savings = Savings.builder()
                .user(user)
                .savingsProduct(savingsProduct)
                .expireDate(LocalDateTime.now().plusMonths(savingsProduct.getSavingsDate()))
                .paymentDate(savingsProduct.getSavingsDate())
                .balance(requestDto.getPaymentMoney())
                .paymentMoney(requestDto.getPaymentMoney())
                .build();

        savingsRepository.save(savings);

        accountService.updateAccount(AccountLogType.SAVINGS, user.getId(), -1 * requestDto.getPaymentMoney());

        log.info("적금 생성");

        SavingsLog savingsLog = SavingsLog.builder()
                .savings(savings)
                .balance(savings.getBalance())
                .build();

        savingsLogRepository.save(savingsLog);

        log.info("적금 로그 저장");
    }

    @Override
    @Transactional(readOnly = true)
    public SavingsResponseDto getSavings(Long userId){
        Savings savings = savingsRepository.findByUserId(userId).orElse(null);

        return SavingsResponseDto.builder()
                .savingsRate(savings.getSavingsProduct().getSavingsRate())
                .savingsDate(savings.getSavingsProduct().getSavingsDate())
                .balance(savings.getBalance())
                .expireDate(savings.getExpireDate())
                .createdAt(savings.getCreatedAt())
                .paymentDate(savings.getPaymentDate())
                .paymentMoney(savings.getPaymentMoney())
                .build();
    }

    @Override
    @Transactional
    public void sendSavings(Long userId){
        Savings savings = savingsRepository.findByUserId(userId).orElse(null);

        // 메인계좌에서 돈 빼오기
        accountService.updateAccount(AccountLogType.SAVINGS, userId, -1 * savings.getPaymentMoney());

        if(savings.getPaymentDate() <= 0){
            // 에러발생
            log.error("적금을 모두 납부하셨습니다.");
        }
        Savings updateSavings = savings.toBuilder()
                .balance(savings.getPaymentMoney() + savings.getBalance())
                .paymentDate(savings.getPaymentDate() - 1)
                .build();

        savingsRepository.save(updateSavings);

        SavingsLog savingsLog = SavingsLog.builder()
                .savings(savings)
                .balance(savings.getPaymentMoney() + savings.getBalance())
                .build();

        savingsLogRepository.save(savingsLog);
    }

    @Override
    public List<SavingsLogResponseDto> getSavingsLogs(Long savingsId) {

        List<SavingsLog> savingsLogs = savingsLogRepository.findAllBySavingsIdOrderByCreatedAtDesc(savingsId);

        List<SavingsLogResponseDto> logDto = savingsLogs.stream().map(
                (savingsLog) -> SavingsLogResponseDto.builder()
                        .paymentMoney(savingsLog.getSavings().getPaymentMoney())
                        .balance(savingsLog.getBalance())
                        .createdAt(savingsLog.getCreatedAt())
                        .build()
        ).collect(Collectors.toList());

        return logDto;
    }
}

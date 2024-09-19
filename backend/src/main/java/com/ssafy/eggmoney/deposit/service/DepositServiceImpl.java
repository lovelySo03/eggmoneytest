package com.ssafy.eggmoney.deposit.service;

import com.ssafy.eggmoney.account.entity.Account;
import com.ssafy.eggmoney.account.entity.AccountLogType;
import com.ssafy.eggmoney.account.repository.AccountRepository;
import com.ssafy.eggmoney.account.service.AccountLogService;
import com.ssafy.eggmoney.account.service.AccountService;
import com.ssafy.eggmoney.deposit.dto.requestdto.DepositCreateRequestDto;
import com.ssafy.eggmoney.deposit.dto.responsedto.DepositProductListResponseDto;
import com.ssafy.eggmoney.deposit.dto.responsedto.DepositResponseDto;
import com.ssafy.eggmoney.deposit.dto.DepositProductDto;
import com.ssafy.eggmoney.deposit.entity.Deposit;
import com.ssafy.eggmoney.deposit.entity.DepositProduct;
import com.ssafy.eggmoney.deposit.repository.DepositProductRepository;
import com.ssafy.eggmoney.deposit.repository.DepositRepository;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepositServiceImpl implements DepositService {

    private final UserRepository userRepository;
    private final DepositRepository depositRepository;
    private final DepositProductRepository depositProductRepository;
    private final AccountService accountService;

    @Override
    @Transactional(readOnly = true)
    public List<DepositProductListResponseDto> getDepositProducts() {
        List<DepositProduct> productList = depositProductRepository.findAll();

        List<DepositProductListResponseDto> productListDto = productList.stream().map(
                (product) -> DepositProductListResponseDto.builder()
                        .productId(product.getId())
                        .depositDate(product.getDepositDate())
                        .depositRate(product.getDepositRate())
                        .build())
                .collect(Collectors.toList());

        log.info("예금 상품 리스트 조회");

        return productListDto;
    }
    @Override
    @Transactional
    public void createDeposit(DepositCreateRequestDto requestDto){
        User user = userRepository.findById(requestDto.getUserId()).orElse(null);
        DepositProduct depositProduct = depositProductRepository.findById(requestDto.getDepositProductId()).orElse(null);

        // 메인 계좌의 돈 깎여야함.
        accountService.updateAccount(AccountLogType.DEPOSIT, requestDto.getUserId(), -1 * requestDto.getDepositMoney());

        LocalDateTime expiration = LocalDateTime.now().plusMonths(depositProduct.getDepositDate());

        if(!user.getRole().equals("자녀")){
            // 에러발생
            log.error("예금 가입 권한이 없는 유저입니다.");
        }

        if(depositRepository.findByUserId(requestDto.getUserId()).isPresent()){
            // 에러발생
            log.error("이미 사용자가 예금상품을 가지고 있습니다.");
        }

        Deposit deposit = Deposit.builder()
                .user(user)
                .depositProduct(depositProduct)
                .expireDate(expiration)
                .depositMoney(requestDto.getDepositMoney())
                .build();

        Deposit savedDeposit = depositRepository.save(deposit);
        log.info("예금 생성 완료");
        // return 저장된 예금 정보?

    }


    @Override
    @Transactional(readOnly = true)
    public DepositResponseDto getDeposits(long userId){
        Deposit deposit = depositRepository.findByUserId(userId).orElse(null);

        if(deposit == null){
            log.info("가입된 예금 상품이 없습니다.");
        }
        DepositProduct depositProduct = deposit.getDepositProduct();
        DepositProductDto depositProductDto = DepositProductDto.builder()
                .id(depositProduct.getId())
                .rate(depositProduct.getDepositRate())
                .date(depositProduct.getDepositDate()).build();

        log.info("예금 조회");
        return DepositResponseDto.builder()
                .depositProduct(depositProductDto)
                .expireDate(deposit.getExpireDate())
                .depositMoney(deposit.getDepositMoney())
                .depositMoney(deposit.getDepositMoney())
                .build();
    }


}

package com.ssafy.eggmoney.deposit.controller;


import com.ssafy.eggmoney.deposit.dto.requestdto.DepositCreateRequestDto;
import com.ssafy.eggmoney.deposit.dto.responsedto.DepositProductListResponseDto;
import com.ssafy.eggmoney.deposit.dto.responsedto.DepositResponseDto;
import com.ssafy.eggmoney.deposit.service.DepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fin/deposit")
public class DepositController {

    private final DepositService depositService;

    /**
     * 전체 예금 상품 조회
     * return DepositProductResponseDto
     * */
    @GetMapping("/product")
    public ResponseEntity<List<DepositProductListResponseDto>> getAllDepositProduct() {
        List<DepositProductListResponseDto> result = depositService.getDepositProducts();
        return ResponseEntity.ok().body(result);
    }


    /**
    * 예금생성
    * @param requestDto
    * return
    * */
    @PostMapping("/create")
    public ResponseEntity<?> createDeposit(@RequestBody DepositCreateRequestDto requestDto) {
        depositService.createDeposit(requestDto);

        return ResponseEntity.ok().build();
    }

    /**
     * 개인 예금 조회
     * @param userId
     * return DepositResponseDto
    * */
    @GetMapping("/{userId}")
    public ResponseEntity<DepositResponseDto> getDeposits(@PathVariable long userId) {
        DepositResponseDto result = depositService.getDeposits(userId);
        log.info(result.toString());
        return ResponseEntity.ok().body(result);
    }



}

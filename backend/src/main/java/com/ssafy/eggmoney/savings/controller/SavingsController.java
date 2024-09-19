package com.ssafy.eggmoney.savings.controller;

import com.ssafy.eggmoney.deposit.dto.responsedto.DepositProductListResponseDto;
import com.ssafy.eggmoney.savings.dto.requestDto.SavingsCreateRequestDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsLogResponseDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsProductListResponseDto;
import com.ssafy.eggmoney.savings.dto.responseDto.SavingsResponseDto;
import com.ssafy.eggmoney.savings.entity.SavingsLog;
import com.ssafy.eggmoney.savings.service.SavingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fin/savings")
public class SavingsController {

    private final SavingService savingService;

    /**
     * 적금상품 전체 조회
     * return SavingsProductListResponseDto
    * */
    @GetMapping("/product")
    public ResponseEntity<List<SavingsProductListResponseDto>> productList(){
        List<SavingsProductListResponseDto> result = savingService.getSavingProducts();
        return ResponseEntity.ok().body(result);
    }

    /**
     * 적금상품 가입하기
     * return
    * */
    @PostMapping("/create")
    public ResponseEntity<?> createSaving(@RequestBody SavingsCreateRequestDto savingsCreateRequestDto){
        savingService.createSaving(savingsCreateRequestDto);

        return ResponseEntity.ok().build();
    }

    /**
     * 개인적금 조회
     * @param userId
     * return SavingsResponseDto
    * */
    @GetMapping("/{userId}")
    public ResponseEntity<SavingsResponseDto> getSavings(@PathVariable Long userId){
        SavingsResponseDto result = savingService.getSavings(userId);

        return ResponseEntity.ok().body(result);
    }

    /**
     * 적금납입
     * @param userId
     * */
    @PostMapping("/send/{userId}")
    public ResponseEntity<?> sendSavings(@PathVariable Long userId){
        savingService.sendSavings(userId);
        return ResponseEntity.ok().build();
    }

    /**
     * 적금로그 조회
     * @param savingsId
     * return List<SavingsLogResponseDto>
     * */
    @GetMapping("/log/{savingsId}")
    public ResponseEntity<List<SavingsLogResponseDto>> getSavingsLogs(@PathVariable Long savingsId){

        List<SavingsLogResponseDto> result = savingService.getSavingsLogs(savingsId);


        return ResponseEntity.ok().body(result);
    }


}

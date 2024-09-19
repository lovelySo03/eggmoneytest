package com.ssafy.eggmoney.withdrawal.dto.response;

import com.ssafy.eggmoney.user.dto.response.GetUserResponseDto;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.withdrawal.entity.Withdrawal;
import com.ssafy.eggmoney.withdrawal.entity.WithdrawalStatus;
import com.ssafy.eggmoney.withdrawal.entity.WithdrawalType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetWithdrawalResponseDto {
//    신청한 사람
    GetUserResponseDto applyer;
//    신청받은 사람
    GetUserResponseDto applyee;
    int withdrawalPrice;
    WithdrawalStatus type;

}

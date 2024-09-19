package com.ssafy.eggmoney.user.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserReqeusetDto {
    String email;
    String name;
    String role;
//    실제 계좌의 은행
    String bank;
//    실제 계좌
    String realAccount;
//    간편 비번
    String pwd;
}

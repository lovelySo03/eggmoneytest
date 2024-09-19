package com.ssafy.eggmoney.user.dto.response;

import com.ssafy.eggmoney.family.dto.response.GetFamilyResponseDto;
import com.ssafy.eggmoney.family.entity.Family;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class GetUserResponseDto {
    String email;
    GetFamilyResponseDto family;
    String name;
    String role;
    String realAccount;
    String bank;
    String pwd;
    Integer stockRatio;
}

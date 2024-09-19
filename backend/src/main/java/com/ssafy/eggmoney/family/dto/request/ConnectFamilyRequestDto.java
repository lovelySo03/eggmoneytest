package com.ssafy.eggmoney.family.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ConnectFamilyRequestDto {
//    연결하려는 userId ( 테스트용, 실제는 Token으로 대체 )
    Long userId;
}

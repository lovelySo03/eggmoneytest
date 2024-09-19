package com.ssafy.eggmoney.family.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetFamilyRequestDto {
    Long userId;
}

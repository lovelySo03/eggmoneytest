package com.ssafy.eggmoney.family.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetFamilyResponseDto {
    Long presentId;
    String intro;
    String qrcode;
}

package com.ssafy.eggmoney.family.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangeFamilyPresentRequestDto {
    Long userId;
    Long familyId;
}

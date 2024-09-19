package com.ssafy.eggmoney.family.service;

import com.ssafy.eggmoney.family.dto.request.ChangeFamilyPresentRequestDto;
import com.ssafy.eggmoney.family.dto.request.ConnectFamilyRequestDto;
import com.ssafy.eggmoney.family.dto.request.CreateFamilyRequestDto;
import com.ssafy.eggmoney.family.dto.response.GetFamilyResponseDto;
import com.ssafy.eggmoney.family.entity.Family;
import com.ssafy.eggmoney.family.repository.FamilyRepository;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class FamilyServcie {
    private final FamilyRepository familyRepository;
    private final UserRepository userRepository;

//    가족 조회
    public GetFamilyResponseDto getFamily(Long familyId){
        Family fam = familyRepository.findById(familyId).get();
        GetFamilyResponseDto getFamilyResponseDto = GetFamilyResponseDto.builder()
                .presentId(fam.getPresentId())
                .intro(fam.getIntro())
                .qrcode(fam.getQrCode())
                .build();

        return getFamilyResponseDto;
    }

//    가족 생성
    public void createFamily(CreateFamilyRequestDto dto) {
        familyRepository.save(Family.builder()
                .intro(dto.getIntro())
                .qrCode(dto.getQrCode())
                .presentId(dto.getPresentId())
                .build());
    }

//    가족 연결
    public void connectFamily(Long familyId, ConnectFamilyRequestDto dto){
        User user = userRepository.findById(dto.getUserId()).get();
        Family fam = familyRepository.findById(familyId).get();
        user.setFamily(fam);
        familyRepository.save(fam);
    }

//    가족 대표 변경
    public void changeFamilyPresent(ChangeFamilyPresentRequestDto dto){
        User user = userRepository.findById(dto.getUserId()).get();
        Family fam = familyRepository.findById(dto.getFamilyId()).get();
        System.out.println(user.getId());
//        유저가 대표를 바꾸려는 가족에 속해있는지 확인하고 변경
        if ( user.getFamily().getId().equals(fam.getId()) ) {
            fam.setPresentId(user.getId());
            System.out.println(fam.getId());
        }
        familyRepository.save(fam);
    }

}

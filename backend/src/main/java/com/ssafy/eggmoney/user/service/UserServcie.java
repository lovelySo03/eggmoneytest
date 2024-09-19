package com.ssafy.eggmoney.user.service;

import com.ssafy.eggmoney.account.service.AccountService;
import com.ssafy.eggmoney.family.dto.response.GetFamilyResponseDto;
import com.ssafy.eggmoney.family.entity.Family;
import com.ssafy.eggmoney.family.repository.FamilyRepository;
import com.ssafy.eggmoney.user.dto.reqeust.CreateUserReqeusetDto;
import com.ssafy.eggmoney.user.dto.response.GetUserResponseDto;
import com.ssafy.eggmoney.user.entity.User;
import com.ssafy.eggmoney.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Transactional
public class UserServcie {
    private final UserRepository userRepository;
    private final AccountService accountService;
    private final FamilyRepository familyRepository;

//    유저 조회
    public GetUserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).get();
        Family fam = user.getFamily();

        GetUserResponseDto getUserResponseDto = GetUserResponseDto.builder()
                .email(user.getEmail())
                .family(GetFamilyResponseDto
                        .builder()
                        .intro(fam.getIntro())
                        .presentId(fam.getPresentId())
                        .qrcode(fam.getQrCode())
                        .build()
                )
                .name(user.getName())
                .role(user.getRole())
                .realAccount(user.getRealAccount())
                .bank(user.getBank())
                .pwd(user.getSimplePwd())
                .build();
        return getUserResponseDto;
    }

//    유저 생성 ( 생성과 동시에 메인 계좌 생성 )
    public void createUser(CreateUserReqeusetDto dto) {
//        유저 생성
        User user = User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .role(dto.getRole())
                .realAccount(dto.getRealAccount())
                .bank(dto.getBank())
                .simplePwd(dto.getPwd())
                .build();
//        자녀 주식제한비율 설정
        if ( dto.getRole().equals("자녀") )
            user.setStockRatio(50);
        userRepository.saveAndFlush(user);
        System.out.println("유저 생성 완료");

//        메인 계좌 생성
        accountService.createAccount(user.getId());
        System.out.println("계좌 생성 완료");
    }
}

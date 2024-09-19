package com.ssafy.eggmoney.user.controller;

import com.ssafy.eggmoney.user.dto.reqeust.CreateUserReqeusetDto;
import com.ssafy.eggmoney.user.dto.response.GetUserResponseDto;
import com.ssafy.eggmoney.user.service.UserServcie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/profile")
public class UserController {
    private final UserServcie userService;

//    유저 조회
    @GetMapping("/{userId}")
    public GetUserResponseDto getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

//    유저 생성
    @PostMapping("/create")
    public void createuser(@RequestBody CreateUserReqeusetDto dto) {
        System.out.println(dto.getBank());
        userService.createUser(dto);
    }


}

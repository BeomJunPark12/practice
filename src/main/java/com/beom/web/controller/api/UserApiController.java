package com.beom.web.controller.api;

import com.beom.web.dto.ResponseDto;
import com.beom.web.dto.UserDto;
import com.beom.web.model.User;
import com.beom.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserService userService;

    /**
     * 회원가입
     */

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> join(@RequestBody UserDto userDto) {

        log.info("회원가입 메서드 호출" + userDto);
        userService.join(userDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


}

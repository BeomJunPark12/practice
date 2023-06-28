package com.beom.web.controller.api;

import com.beom.web.dto.ResponseDto;
import com.beom.web.dto.UserDto;
import com.beom.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    /**
     * 회원가입
     */

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> join(@RequestBody UserDto userDto) {

        log.info("회원가입 메서드 호출" + userDto);
        userService.join(userDto);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    /**
     * 회원수정
     */
    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody UserDto userDto) {
        userService.update(userDto);

        // 여기서는 트랜잭션이 종료되고 db에 값은 변경됨
        // 하지만 세션값은 변경되지 않은 상태이기 때문에 직접 세션값을 변경해줘야 함

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getName(), userDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}

package com.beom.web.entity;

import com.beom.web.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void 회원가입() throws Exception {
        //given
        User user = User.builder().loginId("aaa").password("1234").name("park")
                .age(20).build();

        //when
        Long join = userService.join(user);

        //then
        Assertions.assertThat(user).isEqualTo(userService.findOne(join).orElseThrow());
    }
}
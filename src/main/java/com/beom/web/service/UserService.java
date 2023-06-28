package com.beom.web.service;

import com.beom.web.dto.UserDto;
import com.beom.web.model.User;
import com.beom.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    /**
     * 회원가입
     */
    @Transactional
    public void join(UserDto userDto) {

        String rawPassword = userDto.getPassword(); // 원래 비번
        String encPassword = encoder.encode(rawPassword);   // 해쉬

        userDto.setPassword(encPassword);
        User user = User.join(userDto);
        userRepository.save(user);
    }

    /**
     * 회원수정 비밀번호만
     */
    @Transactional
    public void update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(()-> {
                    return new IllegalArgumentException("회원 수정 실패");
                });
        String rawPassword = userDto.getPassword();
        String encPassword = encoder.encode(rawPassword);

        user.updateUser(encPassword);
    }
}


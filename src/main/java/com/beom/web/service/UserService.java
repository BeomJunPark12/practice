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
     *
     * @param userDto
     */
    @Transactional
    public void join(UserDto userDto) {

        String rawPassword = userDto.getPassword(); // 원래 비번
        String encPassword = encoder.encode(rawPassword);   // 해쉬

        userDto.setPassword(encPassword);
        User user = User.join(userDto);
        userRepository.save(user);
    }
}


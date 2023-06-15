package com.beom.web.service;

import com.beom.web.entity.User;
import com.beom.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long join(User user) {
        validateDuplicateLoginId(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateLoginId(User user) {
        userRepository.findByLongId(user.getLoginId())
                .ifPresent(m ->{
                    throw new IllegalStateException("이미 존재하는 아이디입니다,");
                });
    }

    /**
     * 회원 전체 조회
     */
    public List<User> findUsers() {
      return   userRepository.findAll();
    }

    /**
     * 회원 단건 조회
     */
    public Optional<User> findOne(Long id) {
        return userRepository.findOne(id);
    }

    /**
     * 로그인
     * @return null 로그인 실패
     */

    public User login(String loginId, String password) {
        return userRepository.findByLongId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}

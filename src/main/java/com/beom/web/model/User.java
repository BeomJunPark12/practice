package com.beom.web.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 30)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private Timestamp createDate;


    //==회원 가입시 롤 부여==//
    public void updateRole(Role role) {
        this.role = role;
    }

    //==사용자 수정==//
    public void updateUser(String password, String name) {
        this.password = password;
        this.name = name;
    }
}

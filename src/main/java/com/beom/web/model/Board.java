package com.beom.web.model;

import com.beom.web.config.auth.PrincipalDetail;
import com.beom.web.dto.BoardForm;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    private int count;  // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

    //==글쓰기==//
    public static Board save(BoardForm boardForm, User user) {
        return Board.builder()
                .title(boardForm.getTitle())
                .content(boardForm.getContent())
                .count(0)
                .user(user)
                .build();
    }

}

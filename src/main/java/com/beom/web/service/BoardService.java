package com.beom.web.service;

import com.beom.web.dto.BoardForm;
import com.beom.web.model.Board;
import com.beom.web.model.User;
import com.beom.web.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 글쓰기
     * @param boardForm
     * @param user
     */

    @Transactional
    public void write(BoardForm boardForm, User user) {
        Board board = Board.save(boardForm, user);
        boardRepository.save(board);
    }

    /**
     * 글목록
     */
    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    /**
     * 글 상세보기
     */
    public Board boardView(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(()-> {
                    return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
                });
    }

    /**
     * 글삭제
     */
    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}

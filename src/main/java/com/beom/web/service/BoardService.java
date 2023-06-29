package com.beom.web.service;

import com.beom.web.dto.BoardForm;
import com.beom.web.dto.ReplyDto;
import com.beom.web.dto.UserDto;
import com.beom.web.model.Board;
import com.beom.web.model.Reply;
import com.beom.web.model.User;
import com.beom.web.repository.BoardRepository;
import com.beom.web.repository.ReplyRepository;
import com.beom.web.repository.UserRepository;
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
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

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

    /**
     * 글수정
     */
    @Transactional
    public void update(Long id, BoardForm boardForm) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> {
                   return new IllegalArgumentException("글수정 실패: 글을 찾을 수 없습니다.");
                }); // 영속화 완료
        board.update(boardForm);// 해당 함수 종료시에 트랜잭션이 종료된다 이 때 더티체킹 일어남
    }

    /**
     * 댓글쓰기
     */

    @Transactional
    public void replyWrite(ReplyDto replyDto) {

        Board board = boardRepository.findById(replyDto.getBoardId())
                .orElseThrow(()-> {
                    return new IllegalArgumentException("댓글 쓰기 실패: 게시글 id를 찾을 수 없습니다.");
                }); // 영속화 완료

        User user = userRepository.findById(replyDto.getUserId())
                .orElseThrow(()-> {
                    return new IllegalArgumentException("댓글 쓰기 실패: 유저 id를 찾을 수 없습니다.");
                }); // 영속화 완료

        Reply reply = new Reply();
        reply.save(user, board, replyDto);

        replyRepository.save(reply);
    }

    /**
     * 댓글 삭제
     * @param replyId
     */
    @Transactional
    public void replyDelete(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}

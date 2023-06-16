package com.beom.web.controller;

import com.beom.web.controller.board.BoardForm;
import com.beom.web.entity.Board;
import com.beom.web.entity.User;
import com.beom.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시판 홈
     */

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("list", boardService.findAll());
        return "board/board";
    }

    /**
     * 글 쓰기 폼
     */

    @GetMapping("/board/write")
    public String boardForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "board/boardForm";
    }

    /**
     * 글 쓰기
     */

    @PostMapping("/board/write")
    public String createBoard(@Valid BoardForm boardForm, BindingResult result,
                              @SessionAttribute(name = SessionConst.LOGIN_USER, required = false) User loginUser) {
        if (result.hasErrors()) {
            log.info("errors = {}", result);
            return "board/boardForm";
        }
        System.out.println("loginUser = " + loginUser);
        boardService.register(boardForm.getTitle(), boardForm.getContent(), loginUser.getId());
        return "redirect:/board";
    }

    /**
     * 게시글 상세 보기
     */
    @GetMapping("/board/view/{id}")
    public String boardView(@PathVariable Long id, Model model) {

        log.info("boardView");
        Board board = boardService.findOne(id).orElseThrow();
        model.addAttribute("board", board);

        return "board/boardView";
    }

    /**
     * 게시글 수정
     */

    @GetMapping("/board/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        Board board = boardService.findOne(id).orElseThrow();

        BoardForm boardForm = new BoardForm();
        boardForm.setTitle(board.getTitle());
        boardForm.setContent(board.getContent());

        model.addAttribute("boardForm", boardForm);
        model.addAttribute("id", id);

        return "board/updateForm";
    }

    @PostMapping("/board/update/{id}")
    public String update(@PathVariable Long id, BoardForm boardForm) {
        boardService.updateBoard(id, boardForm.getTitle(), boardForm.getContent());
        return "redirect:/board/view/" + id;
    }

    /**
     * 게시글 삭제
     */

    @PostMapping("/board/delete/{id}")
    public String delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return "redirect:/board";
    }
}

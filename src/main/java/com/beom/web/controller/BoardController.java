package com.beom.web.controller;

import com.beom.web.dto.BoardForm;
import com.beom.web.model.Board;
import com.beom.web.service.BoardService;
import com.beom.web.validator.BoardValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시판 홈
     */
    @GetMapping("board/list")
    public String boardList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)
    Pageable pageable) {

        model.addAttribute("boards", boardService.list(pageable));
        return "board/boardList";
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
     * 글 상세보기
     */

    @GetMapping("board/detail/{id}")
    public String boardDetail(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.boardView(id));
        return "board/boardDetail";
    }

    /**
     * 글수정
     */
    @GetMapping("board/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("board", boardService.boardView(id));

        return "board/updateForm";
    }
}

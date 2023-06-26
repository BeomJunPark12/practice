package com.beom.web.controller.api;


import java.util.List;

import com.beom.web.config.auth.PrincipalDetail;
import com.beom.web.dto.BoardForm;
import com.beom.web.dto.ResponseDto;
import com.beom.web.model.Board;
import com.beom.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
class BoardApiController {

    private final BoardService boardService;

    /**
     * 글쓰기
     */
    @PostMapping("/api/board")
    public ResponseDto<Integer> write(@RequestBody BoardForm boardForm,
                                      @AuthenticationPrincipal PrincipalDetail principal) {

        boardService.write(boardForm, principal.getUser());
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    /**
     * 글삭제
     */
    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> delete(@PathVariable Long id) {

        boardService.delete(id);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }

    /**
     * 글수정
     */
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable Long id, @RequestBody BoardForm boardForm) {
        System.out.println("id = " + id);
        System.out.println("boardForm = " + boardForm.getTitle());
        System.out.println("boardForm = " + boardForm.getContent());
        boardService.update(id, boardForm);
        return new ResponseDto<>(HttpStatus.OK.value(), 1);
    }
}

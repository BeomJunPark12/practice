package com.beom.web.controller.api;


import java.util.List;

import com.beom.web.model.Board;
import com.beom.web.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/boards")
    List<Board> all() {
        return boardService.findAll();
    }

//    @PostMapping("/boards")
//    Board newBoard(@RequestBody BoardForm boardForm) {
//        r
//    }



    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {

        return boardService.findOne(id).orElseThrow(
                () -> new IllegalArgumentException("없는 게시글입니다.")
        );
    }
//
//    @PutMapping("/Boards/{id}")
//    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(Board -> {
//                    Board.setName(newBoard.getName());
//                    Board.setRole(newBoard.getRole());
//                    return repository.save(Board);
//                })
//                .orElseGet(() -> {
//                    newBoard.setId(id);
//                    return repository.save(newBoard);
//                });
//    }
//

    @DeleteMapping("/boards/{id}")
    void deleteBoard(@PathVariable Long id) {
        boardService.deleteById(id);
    }
}

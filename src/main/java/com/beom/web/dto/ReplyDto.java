package com.beom.web.dto;

import com.beom.web.model.Board;
import com.beom.web.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private String content;

    private Long userId;

    private Long boardId;
}

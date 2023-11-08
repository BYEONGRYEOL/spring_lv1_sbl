package com.main.sbl_spring_lv1.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "게시글 삭제 요청 스키마")
public class PostDeleteRequest {
    @Schema(description = "비밀번호", example = "a123456789")
    private String password;
}

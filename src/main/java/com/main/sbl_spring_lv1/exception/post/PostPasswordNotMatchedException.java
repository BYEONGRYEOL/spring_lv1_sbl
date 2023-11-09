package com.main.sbl_spring_lv1.exception.post;

public class PostPasswordNotMatchedException extends RuntimeException {
    public PostPasswordNotMatchedException() {
        super("게시글 비밀번호가 일치하지 않습니다.");
    }
}

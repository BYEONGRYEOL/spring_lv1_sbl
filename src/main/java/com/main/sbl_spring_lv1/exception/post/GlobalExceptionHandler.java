package com.main.sbl_spring_lv1.exception.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 404
    public ResponseEntity<?> handlePostNotFoundException() {
        String errorMessage = "해당 게시글이 존재하지 않습니다.";
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostPasswordNotMatchedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // 401
    public ResponseEntity<?> handlePostPasswordNotMatchedException() {
        String errorMessage = "비밀번호가 일치하지 않습니다.";
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }
}

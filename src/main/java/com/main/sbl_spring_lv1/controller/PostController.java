package com.main.sbl_spring_lv1.controller;


import com.main.sbl_spring_lv1.dto.request.PostRequestDto;
import com.main.sbl_spring_lv1.dto.response.PostResponseDto;
import com.main.sbl_spring_lv1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor  // 서비스 객체  자동 autowire 위해
public class PostController {
    // controller의 역할은 적절한 url, 적절한 요청에 따른 처리 지시, 처리 결과 반환
    private final PostService postService; // final로 선언해서 RequiredArgsConstructor 로 생성자 포함
    @GetMapping("/post/list")
    public List<PostResponseDto> getPostLists(){
        return postService.getPostLists();
    }

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto req){

        return postService.createPost(req);

    }
}

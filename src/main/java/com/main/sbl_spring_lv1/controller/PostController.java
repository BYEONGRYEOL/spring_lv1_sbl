package com.main.sbl_spring_lv1.controller;


import com.main.sbl_spring_lv1.dto.post.PostDeleteRequest;
import com.main.sbl_spring_lv1.dto.post.PostRequest;
import com.main.sbl_spring_lv1.dto.post.PostResponse;
import com.main.sbl_spring_lv1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor  // 서비스 객체  자동 autowire 위해
public class PostController {
    // controller의 역할은 적절한 url, 적절한 요청에 따른 처리 지시, 처리 결과 반환
    private final PostService postService; // final로 선언해서 RequiredArgsConstructor 로 생성자 포함
    @GetMapping("/post/list")
    public List<PostResponse> readAll(){
        return postService.readAll();
    }

    @PostMapping("/post")
    @ResponseBody
    public PostResponse create(@RequestBody PostRequest req){
        return postService.create(req);
    }


    @PutMapping("/post/{id}")
    public PostResponse update(@PathVariable Long id, @RequestBody PostRequest req){
        return postService.update(id, req);
    }

    @DeleteMapping("/post/{id}")
    public void delete(@PathVariable Long id, @RequestBody PostDeleteRequest req){
        postService.delete(id, req);
    }

}

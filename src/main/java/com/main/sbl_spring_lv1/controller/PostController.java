package com.main.sbl_spring_lv1.controller;


import com.main.sbl_spring_lv1.dto.post.PostDeleteRequest;
import com.main.sbl_spring_lv1.dto.post.PostRequest;
import com.main.sbl_spring_lv1.dto.post.PostResponse;
import com.main.sbl_spring_lv1.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequiredArgsConstructor  // 서비스 객체  자동 autowire 위해
@RequestMapping("/post")
@Tag(name = "게시글", description = "게시글 CRUD API")
public class PostController {
    // controller의 역할은 적절한 url, 적절한 요청에 따른 처리 지시, 처리 결과 반환
    private final PostService postService; // final로 선언해서 RequiredArgsConstructor 로 생성자 포함
    @GetMapping("/list")
    @Operation(summary = "게시글 목록 조회", description = "모든 게시글 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공", content = {@Content(schema = @Schema(implementation = PostResponse.class))})
    public List<PostResponse> readAll(){
        return postService.readAll();
    }

    @ResponseBody
    @PostMapping("")
    @Operation(summary = "게시글 생성 요청", description = "게시글을 생성하고 생성된 게시글 정보를 반환받습니다.")
    @ApiResponse(responseCode = "200", description = "성공", content = {@Content(schema = @Schema(implementation = PostResponse.class))})
    public PostResponse create(
            @RequestBody
            @Schema(description = "게시글 생성 요청 스키마", implementation = PostRequest.class)
            PostRequest req
    ){
        return postService.create(req);
    }


    @ResponseBody
    @PutMapping("/{id}")
    public PostResponse update(@PathVariable Long id, @RequestBody PostRequest req){
        return postService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody PostDeleteRequest req){
        postService.delete(id, req);
    }

}

package com.main.sbl_spring_lv1.controller;

import com.main.sbl_spring_lv1.dto.post.PostRequestDto;
import com.main.sbl_spring_lv1.dto.post.PostResponseDto;
import com.main.sbl_spring_lv1.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor  // 서비스 객체  자동 autowire 위해
@Tag(name = "게시글", description = "게시글 CRUD API")
public class PostController {
    // controller의 역할은 적절한 url, 적절한 요청에 따른 처리 지시, 처리 결과 반환
    private final PostService postService; // final로 선언해서 RequiredArgsConstructor 로 생성자 포함

    @GetMapping("/posts")
    @Operation(summary = "게시글 목록 조회", description = "모든 게시글 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공",
            content = {@Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PostResponseDto.class)))
            }
    )
    public List<PostResponseDto> readAll() {
        return postService.readAll();
    }


    @GetMapping("/post/{id}")
    @Operation(summary = "게시글 조회", description = "게시글 id로 게시글 한 개를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PostResponseDto.class)
                    )})
    })
    public PostResponseDto read(
            @PathVariable
            @Schema(description = "게시글 id")
            Long id) {
        return postService.read(id);
    }

    @ResponseBody
    @PostMapping("")
    @Operation(summary = "게시글 생성", description = "게시글을 생성하고 생성된 게시글 정보를 반환받습니다.")
    @ApiResponse(responseCode = "200", description = "성공", content = {@Content(
            mediaType = "application/json",
            schema = @Schema(implementation = PostResponseDto.class))})
    public PostResponseDto create(@RequestBody PostRequestDto req) {
        return postService.create(req);
    }

    @ResponseBody
    @PutMapping("/post/{id}")
    @Operation(summary = "게시글 수정", description = "제목, 작성자, 작성 내용을 수정하고 수정한 게시글을 반환받습니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = {@Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PostResponseDto.class))}),
            @ApiResponse(responseCode = "404", description = "실패 : 게시글이 존재하지 않음"),
            @ApiResponse(responseCode = "401", description = "실패 : 비밀번호 불일치")
    })
    public PostResponseDto update(
            @PathVariable
            @Schema(description = "게시글 id")
            Long id,
            @RequestBody PostRequestDto req
    ) {
        return postService.update(id, req);
    }

    @DeleteMapping("post/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제한 후 삭제된 게시글 id를 반환받습니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공", content = {@Content(
                    mediaType = "text/plain",
                    schema = @Schema(type = "number", description = "삭제된 게시글 db id")
            )}),
            @ApiResponse(responseCode = "404", description = "실패 : 게시글이 존재하지 않음"),
            @ApiResponse(responseCode = "401", description = "실패 : 비밀번호 불일치")}
    )
    public Long delete(
            @PathVariable
            @Schema(description = "게시글 id")
            Long id,
            @RequestBody PostRequestDto req //RequestHeader
    ) {
        return postService.delete(id, req);

    }

}

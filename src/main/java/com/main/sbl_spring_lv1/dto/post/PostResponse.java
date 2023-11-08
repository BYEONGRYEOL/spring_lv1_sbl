package com.main.sbl_spring_lv1.dto.post;

import com.main.sbl_spring_lv1.dto.common.DtoTimeStamp;
import com.main.sbl_spring_lv1.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "게시글 응답 스키마")
public class PostResponse extends DtoTimeStamp {
    @Schema(description = "게시글 db id")
    private Long id;
    @Schema(description = "제목")
    private String title;
    @Schema(description = "작성자 명")
    private String author;
    @Schema(description = "작성 내용")
    private String contents;

    public PostResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}

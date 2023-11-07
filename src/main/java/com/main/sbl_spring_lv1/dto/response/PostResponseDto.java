package com.main.sbl_spring_lv1.dto.response;

import com.main.sbl_spring_lv1.model.Post;

import java.util.Date;

public class PostResponseDto {
    private Long id;
    private String title;
    private String author;

    // 응답에는 password가 있으면 안된다.
    //private String password;
    private String contents;

    private Date creationDate;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.contents = post.getContents();
        this.creationDate = post.getCreationDate();
    }
}

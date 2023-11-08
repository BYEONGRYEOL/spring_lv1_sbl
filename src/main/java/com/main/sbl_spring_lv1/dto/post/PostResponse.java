package com.main.sbl_spring_lv1.dto.post;

import com.main.sbl_spring_lv1.dto.common.DtoTimeStamp;
import com.main.sbl_spring_lv1.entity.Post;
import lombok.Getter;

@Getter
public class PostResponse extends DtoTimeStamp {
    private Long id;
    private String title;
    private String author;
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

// 응답에는 password가 있으면 안된다.
//private String password;
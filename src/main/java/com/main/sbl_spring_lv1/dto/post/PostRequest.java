package com.main.sbl_spring_lv1.dto.post;

import com.main.sbl_spring_lv1.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "게시글 요청")
public class PostRequest {
    // 요청하는 당시에 입력받을 것들,
    // id, date는 서버에서 추가 후 db 저장할 것
    @Schema(description = "제목", example = "게시글 제목")
    private String title;
    @Schema(description = "작성자", example = "홍길동")
    private String author;
    @Schema(description = "내용", example = "게시글 내용")
    private String contents;
    @Schema(description = "비밀번호", example = "password")
    private String password;



    // postrequest는 post를 위해 존재한다. post가 request를 알게 하는 것보다 request가 post를 알게 하는 것이 의존성 관리에 좋을듯
    public Post toEntity(){
        Post post = new Post();
        post.setTitle(title);
        post.setContents(contents);
        post.setPassword(password);
        post.setAuthor(author);
        return post;
    }

}

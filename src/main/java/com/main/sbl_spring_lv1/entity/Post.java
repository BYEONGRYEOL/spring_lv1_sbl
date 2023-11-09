package com.main.sbl_spring_lv1.entity;

import com.main.sbl_spring_lv1.dto.post.PostRequestDto;
import com.main.sbl_spring_lv1.entity.common.EntityTimestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
public class Post extends EntityTimestamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db primary key(id) 자동생성
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "contents", nullable = false)
    private String contents;



    public void update(PostRequestDto req) {
        this.title = req.getTitle();
        this.contents = req.getContents();
        this.author = req.getAuthor();
    }
    public Post(String title, String author, String contents, String password) {
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.password = password;
    }
}

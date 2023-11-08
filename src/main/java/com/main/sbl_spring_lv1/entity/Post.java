package com.main.sbl_spring_lv1.entity;

import com.main.sbl_spring_lv1.dto.post.PostRequest;
import com.main.sbl_spring_lv1.entity.common.EntityTimestamp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
// @AllArgsConstructor id를 개발자가 건들 수 있게 하면 안될 것 같다.
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

    public void update(PostRequest req) {
        this.title = req.getTitle();
        this.contents = req.getContents();
        this.author = req.getAuthor();
    }
}

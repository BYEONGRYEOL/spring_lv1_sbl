package com.main.sbl_spring_lv1.model;

import com.main.sbl_spring_lv1.dto.request.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
// @AllArgsConstructor id를 개발자가 건들 수 있게 하면 안될 것 같다.
@Table(name = "post")
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db primary key(id) 자동생성
    private Long id;
    @Column(name = "title", nullable = false, length = 100) // 문제엔 없지만 제목이 100자가 넘으면 보기 싫을 것 같아서..
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "contents", nullable = false, length = 1000)
    private String contents;


    // TODO: 2023-11-08 작성일자 자동으로 생성되는거 알아보기
    @Column(name = "creationDate", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date creationDate;


    public Post(PostRequestDto req) {
        this.id = req.getId();
        this.title = req.getTitle();
        this.author =req.getAuthor();
        this.password = req.getPassword();
        this.contents = req.getContents();
    }
}

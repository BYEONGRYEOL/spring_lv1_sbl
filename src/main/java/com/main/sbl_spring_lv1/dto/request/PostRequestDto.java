package com.main.sbl_spring_lv1.dto.request;

import lombok.Getter;

import java.util.Date;

@Getter
public class PostRequestDto {
    private Long id;
    private String title;
    private String author;
    private String password;
    private String contents;

    private Date creationDate;
}

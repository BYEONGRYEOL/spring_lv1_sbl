package com.main.sbl_spring_lv1.service;

import com.main.sbl_spring_lv1.dto.request.PostRequestDto;
import com.main.sbl_spring_lv1.dto.response.PostResponseDto;
import com.main.sbl_spring_lv1.model.Post;
import com.main.sbl_spring_lv1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDto> getPostLists() {
        return postRepository.findAll().stream().map(PostResponseDto::new).toList(); // PostResponseDto 클래스에 Post를 매개변수로 받는 생성자가 있기에 사용 가능
    }

    public PostResponseDto createPost(PostRequestDto req) {
        Post post = new Post(req); //req -> entity
        Post savedPost = postRepository.save(post); //save entity
        return new PostResponseDto(savedPost); // entity -> response
    }
}

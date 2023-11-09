package com.main.sbl_spring_lv1.service;

import com.main.sbl_spring_lv1.dto.post.PostRequestDto;
import com.main.sbl_spring_lv1.dto.post.PostResponseDto;
import com.main.sbl_spring_lv1.entity.Post;
import com.main.sbl_spring_lv1.exception.post.PostNotFoundException;
import com.main.sbl_spring_lv1.exception.post.PostPasswordNotMatchedException;
import com.main.sbl_spring_lv1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDto read(Long id) {
        return new PostResponseDto(findPost(id));
    }

    public List<PostResponseDto> readAll() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).toList(); // PostResponseDto 클래스에 Post를 매개변수로 받는 생성자가 있기에 사용 가능
    }

    public PostResponseDto create(PostRequestDto req) {
        Post post = req.toEntity();
        Post savedPost = postRepository.save(post); //save entity
        return new PostResponseDto(savedPost); // entity -> response
    }

    @Transactional
    public PostResponseDto update(Long id, PostRequestDto req) {
        Post post = findPost(id);
        if (StringUtils.equals(post.getPassword(), req.getPassword())) {
            post.update(req);
            return new PostResponseDto(post);
        }
        throw new PostPasswordNotMatchedException();
    }

    public Long delete(Long id, PostRequestDto req) {
        Post post = findPost(id);
        if (StringUtils.equals(req.getPassword(), post.getPassword())) {
            postRepository.delete(post);
            return id;
        }
        throw new PostPasswordNotMatchedException();
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

}

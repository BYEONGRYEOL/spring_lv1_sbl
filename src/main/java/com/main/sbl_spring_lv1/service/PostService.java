package com.main.sbl_spring_lv1.service;

import com.main.sbl_spring_lv1.dto.post.PostRequest;
import com.main.sbl_spring_lv1.dto.post.PostResponse;
import com.main.sbl_spring_lv1.entity.Post;
import com.main.sbl_spring_lv1.exception.post.PostNotFoundException;
import com.main.sbl_spring_lv1.exception.post.PostPasswordNotMatchedException;
import com.main.sbl_spring_lv1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponse> readAll() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponse::new).toList(); // PostResponseDto 클래스에 Post를 매개변수로 받는 생성자가 있기에 사용 가능
    }

    public PostResponse create(PostRequest req) {
        Post post = req.toEntity();
        Post savedPost = postRepository.save(post); //save entity
        return new PostResponse(savedPost); // entity -> response
    }


    @Transactional
    public PostResponse update(Long id, PostRequest req) {
        Post post =findPost(id);
        if (post.getPassword().equals(req.getPassword())) { // eqauls 안쓰고 == 썼다가 한참 고생함
            post.update(req);
            return new PostResponse(post);
        }
        throw new PostPasswordNotMatchedException();
    }

    public Long delete(Long id, String password) {
        Post post =findPost(id);
        if (password.equals(post.getPassword())){
            postRepository.delete(post);
            return id;
        }
        throw new PostPasswordNotMatchedException();
    }

    private Post findPost(Long id){
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return post;
    }

}

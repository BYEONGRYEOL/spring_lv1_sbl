package com.main.sbl_spring_lv1.service;

import com.main.sbl_spring_lv1.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks PostService postService;
    @Mock PostRepository postRepository;

    @Test
    void getPostListsTest() {
        //when
        postService.readAll();

        //then
    }

    @Test
    void createPostTest() {
        //given
//        //요청 들어왓다 치고
//        PostRequest req = new PostRequest("title", "author", "password", "contents");
//        // save를 했을 때
//        Post post = new Post();
//        post.setId(anyLong());
//        post.setTitle(anyString());
//        post.setContents(anyString());
//        post.setAuthor(anyString());
//        post.setPassword(anyString());
//        post.setCreatedAt(LocalDateTime.now());
//        post.setModifiedAt(LocalDateTime.now());
//        given(postRepository.save(req.toEntity())).willReturn(post);
//
//        //when
//        postService.create(req);
//
//        //then
//        verify(postRepository).save(any());
    }
}
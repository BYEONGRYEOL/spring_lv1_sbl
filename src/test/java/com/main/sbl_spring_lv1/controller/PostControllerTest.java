package com.main.sbl_spring_lv1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.sbl_spring_lv1.dto.post.PostRequestDto;
import com.main.sbl_spring_lv1.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest // 테스트 관련 모든 빈을 로드한다.
@WebMvcTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PostService postService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void readAllMVCTest() throws Exception {
        //MockMvcRequest사용을 위해
        //Builder 클래스로 get 요청 후 기대하는 상태를 명시
        //요청시 파라미터 없음
        // 우선 요청을 보내고 200 response를 받는지만 테스트
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/posts"))
                .andExpect(status().isOk())
                .andExpect(view().name("/posts"))
                .andExpect(jsonPath("$.status").value("200"));

        // TODO: 2023-11-09 service Mock 객체 활용 응답 json 테스트
    }

    @Test
    void createSuccessTest() throws Exception {
        // 우선 요청을 보내고 200 response를 받는지만 테스트
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createReq())))
                .andExpect(status().isOk());
        // TODO: 2023-11-09 service Mock 객체 활용 응답 json 테스트
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    public PostRequestDto createReq() {
        return new PostRequestDto("title", "author", "contents", "password");
    }

}
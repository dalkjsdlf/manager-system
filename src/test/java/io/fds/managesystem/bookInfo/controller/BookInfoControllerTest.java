package io.fds.managesystem.bookInfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fds.managesystem.common.constant.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("책 정보 조회")
@SpringBootTest
@AutoConfigureMockMvc
public class BookInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("[성공] 조건없이 도서정보 조회")
    @Test
    public void 주어진것없이_다건도서조회_다건도출() throws Exception {
        //given
        String userId = "dalkjsdlf";
        String url    = TestConstant.CONST_SERVER_URL + "bookInfo";
        //when
        ResultActions resultActions = mockMvc.perform(get(url).
                header("X_USER_ID",userId).
                contentType(MediaType.APPLICATION_JSON));
        //then

        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$", hasSize(greaterThan(0))));;
    }

    @DisplayName("[성공] 제목으로 도서조회")
    @Test
    public void 도서명조건_다건도서조회_다건도출() throws Exception {
        //given
        String userId = "dalkjsdlf";
        String url    = TestConstant.CONST_SERVER_URL + "bookInfo";
        String title  = "도서명";
        //when
        ResultActions resultActions = mockMvc.perform(get(url).
                header("X_USER_ID",userId).
                param("title","title").
                contentType(MediaType.APPLICATION_JSON));
        //then

        resultActions.andExpect(status().isOk());
        resultActions.andExpect(jsonPath("$", hasSize(greaterThan(0))));;
    }

}

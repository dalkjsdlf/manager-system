package io.fds.managesystem.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fds.managesystem.web_api.account.dto.AccountRequestDto;
import io.fds.managesystem.domain.account.entity.Account;
import io.fds.managesystem.domain.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("")
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    final private String hostname = "";
    @BeforeEach
    public void init(){
    }

    @DisplayName("Not Null Test")
    @Test()
    public void given_whenNotNullTet_then(){
        //given

        //when

        //then
        assertThat(mockMvc).isNotNull();
    }

    @DisplayName("[성공] 아이디와 APPLICATION을 입력하면 비밀번호 정상 출력")
    @Test()
    public void given아이디와APP입력_when비밀번호출력_then비밀번호() throws Exception {
        //given
        String userIdInApp="yhchoi7176";
        String userId="dalkjsdlf";
        String password="12341234";
        String appName="hiworks";
        String url = "http://localhost:8500/api/v1/accounts";
        //when
        ResultActions resultActions = mockMvc.perform(get(url).
                header("X_USER_ID",userId).
                param("userIdInApp",userIdInApp).
                param("appName",appName).
                contentType(MediaType.APPLICATION_JSON));

        //then
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("$.password").value(password));
    }

    @DisplayName("[성공] ID,APP,PASSWORD로 등록")
    @Test()
    public void given아이디와APPPW입력_when계정등록_then등록성공() throws Exception {
        //given
        String appUserId="yhchoi7176";
        String userId="181012";
        String password="12341234";
        String appName="hiwork";
        String url = String.format("http://localhost:8500/accounts");

        AccountRequestDto accountRequestDto = AccountRequestDto.builder().
                userId(userId).
                appUserId(appUserId).
                appName(appName).
                password(password).build();

        //when
        ResultActions resultActions = mockMvc.perform(post(url).
                header("X_USER_ID",userId).
                content(objectMapper.writeValueAsString(accountRequestDto)).
                contentType(MediaType.APPLICATION_JSON));

        //then
        resultActions.andExpect(status().isCreated());



        //then
    }

//    @DisplayName("[성공] ID,APP,PASSWORD를 입력하여 수정")
//    @Test()
//    public void given아이디와APP입력_when비밀번호출력_then비밀번호(){
//        //given
//
//
//        //when
//
//
//
//        //then
//        assertThat();
//    }
//
//    @DisplayName("[성공] ID,APP을 조건으로 삭제")
//    @Test()
//    public void given아이디와APP입력_when비밀번호출력_then비밀번호(){
//        //given
//
//
//        //when
//
//
//
//        //then
//        assertThat();
//    }
}

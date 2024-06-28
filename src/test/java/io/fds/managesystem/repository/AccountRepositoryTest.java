package io.fds.managesystem.repository;

import io.fds.managesystem.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    public void init()
    {
        accountRepository.save(Account.of("181012","dalkjsdlf","hiworks","12341234"));
    }

    @DisplayName("")
    @Test()
    public void given_whenNotNull_then(){
        //given


        //when

        //then
        assertThat(accountRepository);
    }

    @DisplayName("")
    @Test()
    public void givenUserIdUserIdInAppAppId_whenFindAccount_thenAccount() {
        //given
        String userId = "181012";
        String userIdInApp = "dalkjsdlf";
        String appName = "hiworks";
        //when

        Account result = accountRepository.findAccountByUserIdAndUserIdInAppAndAppId(userId, userIdInApp, appName);

        //then
        assertThat(result).isNotNull();

    }
}

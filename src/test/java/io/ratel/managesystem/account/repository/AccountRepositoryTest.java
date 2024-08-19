package io.ratel.managesystem.account.repository;

import io.ratel.managesystem.domain.account.repository.AccountRepository;
import io.ratel.managesystem.domain.account.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("")
@SpringBootTest
@Slf4j
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    public void init()
    {
        //accountRepository.save(Account.of("181012","dalkjsdlf","hiworks","12341234"));
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
        String userId = "dalkjsdlf";
        String appUserId = "yhchoi7176";
        String appName = "hiworks";
        //when

        Account result = accountRepository.findAccountByUserIdAndAppUserIdAndAppName(userId, appUserId, appName);

        //then
        assertThat(result).isNotNull();

    }

    @DisplayName("")
    @Test()
    public void 주어지는건없고_전체조회_잘나오는거다() {
        //given

        //when

        List<Account> result = accountRepository.findAll();

        //then
        assertThat(result.size()).isNotEqualTo(0);

    }
}

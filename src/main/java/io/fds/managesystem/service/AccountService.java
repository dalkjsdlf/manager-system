package io.fds.managesystem.service;

import io.fds.managesystem.dto.AccountRequestDto;
import io.fds.managesystem.dto.AccountResponseDto;
import io.fds.managesystem.entity.Account;
import io.fds.managesystem.exception.AccountErrorResult;
import io.fds.managesystem.exception.AccountException;
import io.fds.managesystem.repository.AccountRepository;
import io.fds.managesystem.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDto getPw(String userId, String userIdInApp, String appName){

        Account account = accountRepository.findAccountByUserIdAndUserIdInAppAndAppId(userId, userIdInApp, appName);

        if(account == null){
            throw new AccountException(AccountErrorResult.NOT_FOUND);
        }

        return AccountResponseDto.
                builder().
                password(account.getPassword()).
                userIdInApp(account.getUserIdInApp()).
                build();
    }

    public void registerAccount(AccountRequestDto accountRequestDto,
                                String userId
                                ){
        String userIdInApp = accountRequestDto.userIdInApp;
        String appName     = accountRequestDto.appName;
        String password    = accountRequestDto.password;

        Account account = Account.of(userId,userIdInApp,appName,password);

        accountRepository.save(account);
    }
}

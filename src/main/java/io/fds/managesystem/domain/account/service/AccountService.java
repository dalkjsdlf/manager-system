package io.fds.managesystem.domain.account.service;

import io.fds.managesystem.web_api.account.dto.AccountRequestDto;
import io.fds.managesystem.web_api.account.dto.AccountResponseDto;
import io.fds.managesystem.domain.account.entity.Account;
import io.fds.managesystem.common.exception.BusinessErrorResult;
import io.fds.managesystem.common.exception.BusinessException;
import io.fds.managesystem.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountResponseDto getPw(String userId, String userIdInApp, String appName){

        Account account = accountRepository.findAccountByUserIdAndAppUserIdAndAppName(userId, userIdInApp, appName);

        if(account == null){
            throw new BusinessException(BusinessErrorResult.NOT_FOUND);
        }

        return AccountResponseDto.convertToDto(account);
    }

    public void registerAccount(AccountRequestDto accountRequestDto,
                                String userId
                                ){
        String userIdInApp = accountRequestDto.appUserId();
        String appName     = accountRequestDto.appName();
        String password    = accountRequestDto.password();

        Account account = Account.of(userId,userIdInApp,appName,password);

        accountRepository.save(account);
    }
}

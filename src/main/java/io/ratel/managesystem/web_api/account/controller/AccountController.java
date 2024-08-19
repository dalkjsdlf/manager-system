package io.ratel.managesystem.web_api.account.controller;

import io.ratel.managesystem.web_api.account.dto.AccountRequestDto;
import io.ratel.managesystem.web_api.account.dto.AccountResponseDto;
import io.ratel.managesystem.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("")
    public ResponseEntity<AccountResponseDto> getPw(@RequestHeader("X_USER_ID") String userId,
                                                    @RequestParam String appUserId,
                                                    @RequestParam String appName){
        log.info("Enter the getPassword Controller");
        return ResponseEntity.ok(accountService.getPw(userId, appUserId, appName));
    }

    @PostMapping("")
    public ResponseEntity<AccountResponseDto> registerAccount(@RequestHeader("X_USER_ID") String userId,
                                                    @RequestBody final AccountRequestDto accountRequestDto){
        accountService.registerAccount(accountRequestDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

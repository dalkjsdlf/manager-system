package io.fds.managesystem.controller;

import io.fds.managesystem.dto.AccountRequestDto;
import io.fds.managesystem.dto.AccountResponseDto;
import io.fds.managesystem.service.AccountService;
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
                                                    @RequestParam String userIdInApp,
                                                    @RequestParam String appName){
        return ResponseEntity.ok(accountService.getPw(userId, userIdInApp, appName));
    }

    @PostMapping("")
    public ResponseEntity<AccountResponseDto> registerAccount(@RequestHeader("X_USER_ID") String userId,
                                                    @RequestBody final AccountRequestDto accountRequestDto){
        accountService.registerAccount(accountRequestDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

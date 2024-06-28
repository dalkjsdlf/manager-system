package io.fds.managesystem.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountException extends RuntimeException{

    private final AccountErrorResult errorResult;
}

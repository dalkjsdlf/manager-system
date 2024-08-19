package io.ratel.managesystem.common.exception;

import io.ratel.managesystem.common.exception.BusinessErrorResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException{

    private final BusinessErrorResult errorResult;
}

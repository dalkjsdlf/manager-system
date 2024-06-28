package io.fds.managesystem.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AccountResponseDto {

    public final String userIdInApp;
    public final String password;
}

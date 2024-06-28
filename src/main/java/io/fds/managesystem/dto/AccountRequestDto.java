package io.fds.managesystem.dto;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AccountRequestDto {
    public final String userId;
    public final String userIdInApp;
    public final String appName;
    public final String password;
}

package io.fds.managesystem.web_api.account.dto;

import io.fds.managesystem.domain.account.entity.Account;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
public record AccountResponseDto(String appUserId, String password) {

    public static AccountResponseDto convertToDto(Account account) {
        return AccountResponseDto.builder()
                .appUserId(account.getAppUserId())
                .password(account.getPassword())
                .build();
    }
}
